package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.UserBookRemarkMapper;
import com.feimang.userstudy.pojo.UserBookRemark;
import com.feimang.userstudy.service.IUserBookRemarkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by yxm on 2018/2/8
 */
@Service("userBookRemarkService")
public class UserBookRemarkServiceImpl implements IUserBookRemarkService {
    @Autowired
    private UserBookRemarkMapper userBookRemarkMapper;

    /**
     * 判断是否备注图书
     * @param fromuid
     * @param bookid
     * @return
     */
    public ServerResponse isRemarkBook(Long fromuid,Long bookid){
        if (fromuid== null || bookid== null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        UserBookRemark userBookRemark = userBookRemarkMapper.getRemarkByFromidAndBookID(fromuid, bookid);
        if (userBookRemark != null){
            return ServerResponse.createBySuccess("已备注图书",userBookRemark);
        }
        return ServerResponse.createByErrorMessage("未备注图书");
    }

    /**
     * 获取备注图书列表
     * @param fromuid 用户id
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse getBookRemarksByFromuid(Long fromuid,int pageNum,int pageSize){
        if ( fromuid== null ){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<UserBookRemark> userBookRemarks = userBookRemarkMapper.getBookRemarksByFromuid(fromuid);
        if (CollectionUtils.isNotEmpty(userBookRemarks)){
            PageInfo pageInfo = new PageInfo(userBookRemarks);
            return ServerResponse.createBySuccess("查询成功",pageInfo);
        }
        return ServerResponse.createByErrorMessage("用户未备注图书");
    }

    /**
     * 添加或修改备注
     * @param userBookRemark
     * @return
     */
    public ServerResponse addOrupdateRemark(UserBookRemark userBookRemark){
        if ( userBookRemark== null ){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ServerResponse serverResponse = isRemarkBook(userBookRemark.getFromuid(),userBookRemark.getBookid());
        if (serverResponse.isSuccess()){
            //修改备注
            UserBookRemark remark = (UserBookRemark)serverResponse.getData();
            remark.setRemark(userBookRemark.getRemark());
            userBookRemarkMapper.updateByPrimaryKeySelective(userBookRemark);
            return ServerResponse.createBySuccess("修改备注成功");
        }
        //添加备注
        userBookRemarkMapper.insert(userBookRemark);
        return ServerResponse.createBySuccess("添加备注成功");
    }
}
