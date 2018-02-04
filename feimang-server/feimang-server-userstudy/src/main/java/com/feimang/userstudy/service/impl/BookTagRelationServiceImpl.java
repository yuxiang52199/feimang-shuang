package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.BooktagRelationMapper;
import com.feimang.userstudy.pojo.BooktagRelation;
import com.feimang.userstudy.service.IBookTagRelationService;
import com.feimang.userstudy.vo.BookTagRelations;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yxm on 2018/2/3
 */
@Service("bookTagRelationService")
public class BookTagRelationServiceImpl implements IBookTagRelationService{

    private BooktagRelationMapper booktagRelationMapper;
    /**
     * 获取书架内图书列表
     * @param utid 书架id
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse<List<BooktagRelation>> getBooksByBookTag(Integer utid,int pageNum,int pageSize){
        if ( utid == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);
        System.out.println("utid="+utid);
        //查询
        List<BooktagRelation> booktagRelationList = booktagRelationMapper.getBooksByUTID(utid);
        if (CollectionUtils.isNotEmpty(booktagRelationList)){
            return ServerResponse.createBySuccess("查询成功",booktagRelationList);
        }
        return ServerResponse.createByErrorMessage("书架内没有图书");
    }

    /**
     * 书架内添加图书
     *
     * @param bookTagRelations
     * @return
     */
    public ServerResponse addBookToBookTag(BookTagRelations bookTagRelations){
        if ( CollectionUtils.isEmpty(bookTagRelations.booktagRelations)){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        //todo  查询图书是否存在 存在的话 改变其书架内排序
        return null;
    }

    /**
     * 书架内删除图书
     * @param booktagRelationList
     * @return
     */
    public ServerResponse delBookFromBookTag(List<BooktagRelation> booktagRelationList){
        if ( CollectionUtils.isEmpty(booktagRelationList)){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        // 删除图书
        int resultCount = booktagRelationMapper.delBookByUserIdAndId(booktagRelationList);
        if (resultCount > 0){
            return ServerResponse.createBySuccess("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

}
