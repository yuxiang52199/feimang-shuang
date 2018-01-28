package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.UserBookAttenMapper;
import com.feimang.userstudy.pojo.UserBookAtten;
import com.feimang.userstudy.pojo.UserInfo;
import com.feimang.userstudy.service.IAttenBookService;
import com.feimang.userstudy.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by yxm on 2018/1/27
 */
@Service("iAttenBookService")
public class AttenBookServiceImpl implements IAttenBookService {

    @Autowired
    private UserBookAttenMapper userBookAttenMapper;

    @Autowired
    private IUserService userService;

    /**
     * 添加图书关注
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    public ServerResponse addAttenByUserIdAndBookId(Integer userId,Integer bookId){
        if (userId == null || bookId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        // 插入数据
        UserBookAtten userBookAtten = new UserBookAtten();
        userBookAtten.setFromuid(Long.valueOf(userId));
        int resultCount =userBookAttenMapper.insert(userBookAtten);
        if (resultCount > 0){
            return ServerResponse.createBySuccess("关注成功");
        }
        return ServerResponse.createByErrorMessage("关注失败");
    }

    /**
     * 分页获取用户关注的图书
     * @param userId 用户id
     * @param pageNum 第几页
     * @param pageSize 每页几条数据
     * @return
     */
    public ServerResponse<List<UserBookAtten>> getAttenBooks(Integer userId, int pageNum,int pageSize){
        if (userId == null){
            // 判断参数是否为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);//分页查询
        List<UserBookAtten> userBookAttens = userBookAttenMapper.getAttendBooksByUserId(userId);

        for (UserBookAtten bookAtten:userBookAttens) {
            ServerResponse<UserInfo> user =userService.getUserByUserId(bookAtten.getFromuid());

            System.out.print(user);
        }
        if (CollectionUtils.isNotEmpty(userBookAttens)){
            return ServerResponse.createBySuccess(userBookAttens);
        }
        return ServerResponse.createByErrorMessage("用户还未关注过任何图书");
    }
}
