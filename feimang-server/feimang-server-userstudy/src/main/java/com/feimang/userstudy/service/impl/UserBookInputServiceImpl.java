package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.UserBookInputMapper;
import com.feimang.userstudy.pojo.BookInfo;
import com.feimang.userstudy.pojo.UserBookInput;
import com.feimang.userstudy.service.IUserBookInputService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yxm on 2018/1/29
 */
@Service("userBookInputService")
public class UserBookInputServiceImpl implements IUserBookInputService {

    @Autowired
    private UserBookInputMapper userBookInputMapper;
    //region 手动录入功能
    /**
     * 获取手动录入列表
     * @param userId 用户id
     * @return
     */
    public ServerResponse getInputBooks(Long userId,int pageNum,int pageSize){
        if (userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<UserBookInput> userBookInputList = userBookInputMapper.getInputBooksByUserId(userId);
        if (CollectionUtils.isNotEmpty(userBookInputList)){
            PageInfo pageInfo = new PageInfo(userBookInputList);
            return ServerResponse.createBySuccess("查询成功",pageInfo);
        }
        return ServerResponse.createByErrorMessage("用户尚未录入图书");
    }

    /**
     * 删除手动录入记录
     * @param inputId
     * @return
     */
    public ServerResponse delInputBook(Long inputId){
        if (inputId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        int resultCount = userBookInputMapper.deleteByPrimaryKey(inputId);
        if (resultCount > 0){
            return ServerResponse.createBySuccess("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    /**
     * 手动录入图书
     * @param userId 用户id
     * @param bookInfo 图书实体类
     * @return
     */
    public ServerResponse addInputBook(Long userId, BookInfo bookInfo){
        if (userId == null || bookInfo == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        //todo 插入图书数据 并设置状态
        //插入用户手动录入记录
        UserBookInput userBookInput = new UserBookInput();
        userBookInput.setFromuid(userId);
        userBookInput.setBookid(bookInfo.getBookid());
        int resultCount = userBookInputMapper.insert(userBookInput);
        if (resultCount > 0){
            return ServerResponse.createBySuccess("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }
    //endregion
}
