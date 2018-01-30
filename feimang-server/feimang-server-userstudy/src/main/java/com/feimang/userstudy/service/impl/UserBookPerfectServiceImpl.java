package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.UserBookPerfectMapper;
import com.feimang.userstudy.pojo.UserBookPerfect;
import com.feimang.userstudy.pojo.UserBookPerfectWithBLOBs;
import com.feimang.userstudy.service.IUserBookPerfectService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yxm on 2018/1/29
 */
@Service("userBookPerfectService")
public class UserBookPerfectServiceImpl implements IUserBookPerfectService {
    @Autowired
    private UserBookPerfectMapper userBookPerfectMapper;
    /**
     * 判断是否完善过图书信息
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    public ServerResponse isPerfectBook(Long userId,Integer bookId){
        if (userId == null || bookId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        //查询用户是否完善过图书信息
        UserBookPerfect userBookPerfect = userBookPerfectMapper.selectPerfectBookByUserIDAndBookID(userId, bookId);
        if (userBookPerfect == null){
            return ServerResponse.createByErrorMessage("用户未完善该图书信息");
        }
        return ServerResponse.createBySuccess("用户已完善该图书",userBookPerfect);
    }

    /**
     * 根据用户id 获取完善资料列表
     * @param userId 用户id
     * @return
     */
    public ServerResponse getPerfectBooksByUserID(Long userId){
        if (userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        List<UserBookPerfect> userBookPerfectList = userBookPerfectMapper.getPerfectBooksByUserID(userId);
        if (CollectionUtils.isNotEmpty(userBookPerfectList)){
            return ServerResponse.createBySuccess("查询成功",userBookPerfectList);
        }
        return ServerResponse.createByErrorMessage("用户未完善过图书信息");
    }

    /**
     * 获取完善资料信息
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    public ServerResponse getPerfectBookByUserIdAndBookId(Long userId,Integer bookId){
        if (userId == null || bookId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        UserBookPerfect userBookPerfect = userBookPerfectMapper.selectPerfectBookByUserIDAndBookID(userId, bookId);
        if (userBookPerfect == null){
            return ServerResponse.createByErrorMessage("用户未完善该图书信息");
        }
        return ServerResponse.createBySuccess(userBookPerfect);
    }

    /**
     * 删除完善资料信息
     * @param perfectId 完善资料id
     * @return
     */
    public ServerResponse delPerfectBook(Long perfectId){
        if (perfectId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        int resultCount = userBookPerfectMapper.deleteByPrimaryKey(perfectId);
        if ( resultCount > 0){
            return ServerResponse.createBySuccess("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    /**
     * 编辑完善信息资料
     * @param userBookPerfect
     * @return
     */
    public ServerResponse editPerfectBook(UserBookPerfect userBookPerfect){
        if (userBookPerfect == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        int resultCount = userBookPerfectMapper.updateByPrimaryKey(userBookPerfect);
        if (resultCount > 0){
            return ServerResponse.createBySuccess("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    /**
     * 添加完善资料
     * @param userBookPerfect
     * @return
     */
    public ServerResponse addPerfectBook(UserBookPerfect userBookPerfect,Long userId,Long bookId){
        if (userBookPerfect == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        userBookPerfect.setFromuid(userId);
        userBookPerfect.setBookid(bookId);
        userBookPerfect.setPerfectstatus(0);//设置未审核
        UserBookPerfectWithBLOBs userBookPerfectWithBLOBs = new UserBookPerfectWithBLOBs();
        userBookPerfectWithBLOBs = assembleUserBookPerfectWithBLOBs(userBookPerfect);
        int resultCount = userBookPerfectMapper.insert(userBookPerfectWithBLOBs);
        if (resultCount > 0){
            return ServerResponse.createBySuccess("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }
    // 组装userbookPerfectWithBLOBs
    public UserBookPerfectWithBLOBs assembleUserBookPerfectWithBLOBs(UserBookPerfect userBookPerfect){
        UserBookPerfectWithBLOBs userBookPerfectWithBLOBs = new UserBookPerfectWithBLOBs();
        userBookPerfectWithBLOBs.setPerfectid(userBookPerfect.getPerfectid());
        userBookPerfectWithBLOBs.setFromuid(userBookPerfect.getFromuid());
        userBookPerfectWithBLOBs.setBookid(userBookPerfect.getBookid());
        userBookPerfectWithBLOBs.setBookname(userBookPerfect.getBookname());
        userBookPerfectWithBLOBs.setIsbn(userBookPerfect.getIsbn());
       // userBookPerfectWithBLOBs.getAuthor(userBookPerfect.getAuthor());
        userBookPerfectWithBLOBs.setPublisher(userBookPerfect.getPublisher());
        userBookPerfectWithBLOBs.setPubdate(userBookPerfect.getPubdate());
        userBookPerfectWithBLOBs.setPrice(userBookPerfect.getPrice());
        userBookPerfectWithBLOBs.setCreatetime(userBookPerfect.getCreatetime());
        userBookPerfectWithBLOBs.setLastupdatetime(userBookPerfect.getLastupdatetime());
        userBookPerfectWithBLOBs.setImgflg(userBookPerfect.getImgflg());
        userBookPerfectWithBLOBs.setPerfectstatus(userBookPerfect.getPerfectstatus());
        userBookPerfectWithBLOBs.setCover(userBookPerfect.getCover());
        return userBookPerfectWithBLOBs;
    }
}
