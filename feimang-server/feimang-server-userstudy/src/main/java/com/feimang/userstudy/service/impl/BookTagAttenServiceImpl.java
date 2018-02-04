package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.Const;
import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.BookTagAttenMapper;
import com.feimang.userstudy.dao.BookTagMapper;
import com.feimang.userstudy.pojo.BookTag;
import com.feimang.userstudy.pojo.BookTagAtten;
import com.feimang.userstudy.service.IBookTagAttenService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yxm on 2018/1/30
 */
@Service("bookTagAttenService")
public class BookTagAttenServiceImpl implements IBookTagAttenService{

    @Autowired
    private BookTagAttenMapper bookTagAttenMapper;
    @Autowired
    private BookTagMapper bookTagMapper;

    /**
     * 获取用户关注的书架列表
     * @param userId 用户id
     * @return
     */
    public ServerResponse getAttenBookTags(Long userId,int pageNum,int pageSize){
        if ( userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        // 获取用户关注的书架列表
        PageHelper.startPage(pageNum,pageSize);
        List<BookTagAtten> bookTagAttenList = bookTagAttenMapper.getAttenBookTags(userId);
        if (CollectionUtils.isNotEmpty(bookTagAttenList)){
            return ServerResponse.createBySuccess("查询成功",bookTagAttenList);
        }
        return ServerResponse.createByErrorMessage("当前用户未关注书架");
    }

    /**
     * 添加关注的书架
     * @param userId
     * @param bookTagAtten
     * @return
     */
    public ServerResponse addAttenBookTag(Long userId,BookTagAtten bookTagAtten){
        if ( userId == null || bookTagAtten ==null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ServerResponse serverResponse = isAttenBookTag(userId,bookTagAtten.getUtid());
        if (serverResponse.isSuccess()){
            return ServerResponse.createByErrorMessage("已关注该书架");
        }
        int rowCount = bookTagMapper.selectByUtid(bookTagAtten.getUtid());
        if (rowCount > 0){//书架存在
            bookTagAtten.setFromuid(userId);
            bookTagAtten.setDelflg(Const.BookTagDelFlg.UNDELETED.getCode());
            int resultCount = bookTagAttenMapper.insert(bookTagAtten);
            if (resultCount > 0){
                // 修改该书架的关注人数+1
                BookTag bookTag= bookTagMapper.selectByPrimaryKey(Integer.parseInt(bookTagAtten.getUtid().toString()));
                bookTag.setAttencount(bookTag.getAttencount()+1);
                int count = bookTagMapper.updateByPrimaryKeySelective(bookTag);
                if (count > 0 ){
                    return ServerResponse.createBySuccess("添加成功");
                }
                return ServerResponse.createByErrorMessage("添加失败");
            }
        }
        return ServerResponse.createByErrorMessage("书架不存在");
    }

    /**
     * 判断是否关注书架
     * @param userId 用户id
     * @param utid 书架id
     * @return
     */
    public ServerResponse isAttenBookTag(Long userId,Long utid){
        if ( userId == null || utid ==null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        BookTagAtten bookTagAtten = bookTagAttenMapper.isAttenBookTagByUserIdAndUtid(userId, utid);
        if (bookTagAtten != null){
            return ServerResponse.createBySuccess("用户已关注该书架",bookTagAtten);
        }
        return ServerResponse.createByErrorMessage("用户未关注该书架");
    }

    /**
     * 取消关注书架
     * @param userId 用户id
     * @param attenId 书架关注id
     * @return
     */
        public ServerResponse delAttenBookTag(Long userId,Long attenId){
        if ( userId ==null || attenId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        BookTagAtten bookTagAtten = bookTagAttenMapper.selectByPrimaryKey(attenId);
        if (bookTagAtten == null){
            return ServerResponse.createByErrorMessage("未关注此书架");
        }
      //  System.out.println(userId +":"+bookTagAtten.getFromuid());
        if (bookTagAtten.getFromuid().equals(userId)){
            int resultCount = bookTagAttenMapper.deleteByPrimaryKey(attenId);
            if (resultCount > 0){
                // 该书架的关注人数-1
                BookTag bookTag = bookTagMapper.selectByPrimaryKey(Integer.parseInt(bookTagAtten.getUtid().toString()));
                bookTag.setAttencount(bookTag.getAttencount()-1);//关注人数-1
                int rowCount = bookTagMapper.updateByPrimaryKeySelective(bookTag);
                if (resultCount > 0){
                    return ServerResponse.createBySuccess("取消关注成功");
                }
                return ServerResponse.createByErrorMessage("取消关注失败");
            }
            return ServerResponse.createByErrorMessage("取消关注失败");
        }
        return ServerResponse.createByErrorMessage("用户未关注此书架");
    }
}
