package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.Const;
import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.BookTagMapper;
import com.feimang.userstudy.pojo.BookTag;
import com.feimang.userstudy.service.IBookTagService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yxm on 2018/1/30
 */
@Service("bookTagService")
public class BookTagServiceImpl implements IBookTagService {
    @Autowired
    private BookTagMapper bookTagMapper;
    /**
     * 获取书架列表
     * @param userId 用户id
     * @return
     */
    public ServerResponse<List<BookTag>> getBookTags(Long userId){
        if ( userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        List<BookTag> bookTagList = bookTagMapper.getBookTags(userId);
        if (CollectionUtils.isNotEmpty(bookTagList)){
            return ServerResponse.createBySuccess("查询成功",bookTagList);
        }
        return ServerResponse.createByErrorMessage("用户还未添加书架");
    }

    /**
     * 排序书架
     * @param userId 用户id
     * @param bookTagList
     * @return
     */
    public ServerResponse editBookTagSeq(Long userId,List<BookTag> bookTagList){
        if (CollectionUtils.isEmpty(bookTagList)){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
       int resultCount = bookTagMapper.editBookTag(userId,bookTagList);
        if (resultCount > 0){
            return ServerResponse.createBySuccess("排序成功");
        }
        return ServerResponse.createByErrorMessage("排序失败");
    }

    /**
     * 删除书架
     * @param utid 书架id
     * @return
     */
    public ServerResponse delBookTag(Integer utid){
        if ( utid == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        BookTag bookTag = bookTagMapper.selectByPrimaryKey(utid);
        if (bookTag == null){
            return ServerResponse.createByErrorMessage("书架不存在");
        }
        if (bookTag.getDelflg() == Const.BookTagDelFlg.DELETED.getCode()){
            return ServerResponse.createByErrorMessage("书架已删除");
        }
        bookTag.setDelflg(Const.BookTagDelFlg.DELETED.getCode());
        int resultCount = bookTagMapper.updateByPrimaryKey(bookTag);
        if (resultCount > 0){
            return ServerResponse.createBySuccess("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }
}
