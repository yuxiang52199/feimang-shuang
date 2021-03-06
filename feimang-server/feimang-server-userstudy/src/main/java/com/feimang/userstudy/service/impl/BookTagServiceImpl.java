package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.Const;
import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.BookTagMapper;
import com.feimang.userstudy.pojo.BookTag;
import com.feimang.userstudy.service.IBookTagService;
import com.feimang.userstudy.vo.BookTags;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    //region 书架相关
    /**
     * 获取书架列表
     * @param userId 用户id
     * @return
     */
    public ServerResponse getBookTags(Long userId,int pageNum,int pageSize){
        if ( userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<BookTag> bookTagList = bookTagMapper.getBookTags(userId);
        if (CollectionUtils.isNotEmpty(bookTagList)){
            PageInfo pageInfo = new PageInfo(bookTagList);
            return ServerResponse.createBySuccess("查询成功",pageInfo);
        }
        return ServerResponse.createByErrorMessage("用户还未添加书架");
    }

    /**
     * 排序书架
     * @param userId 用户id
     * @param bookTags
     * @return
     */
    public ServerResponse editBookTagSeq(BookTags bookTags){
        if (CollectionUtils.isEmpty(bookTags.getBookTags())){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
       int resultCount = bookTagMapper.editBookTag(bookTags.getBookTags());
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

    /**
     * 添加书架
     * @param userId 用户id
     * @param bookTag 书架实体
     * @return
     */
    public ServerResponse addBookTag(Long userId,BookTag bookTag){
        if ( userId == null || bookTag == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        int resultCount = bookTagMapper.checkTagNameByUserIdAndTagName(userId,bookTag.getTagname());
        if (resultCount > 0){
            return ServerResponse.createByErrorMessage("书架名字重复");
        }
        bookTag.setFromuid(userId);
        int rowCount = bookTagMapper.insert(bookTag);
        if (rowCount > 0){
            return ServerResponse.createBySuccess("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }

    /**
     * 编辑书架
     * @param bookTag
     * @return
     */
    public ServerResponse editBookTag(BookTag bookTag){
        if ( bookTag == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        int resultCount = bookTagMapper.checkTagNameByUserIdAndTagName(bookTag.getFromuid(),bookTag.getTagname());
        if (resultCount > 0){
            return ServerResponse.createByErrorMessage("书架名字重复");
        }
        int rowCount = bookTagMapper.updateByPrimaryKeySelective(bookTag);
        if (rowCount > 0){
            return ServerResponse.createBySuccess("编辑成功");
        }
        return ServerResponse.createByErrorMessage("编辑失败");
    }
    //endregion
}
