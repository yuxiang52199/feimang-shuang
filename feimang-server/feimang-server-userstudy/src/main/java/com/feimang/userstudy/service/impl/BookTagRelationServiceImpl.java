package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.BookTagMapper;
import com.feimang.userstudy.dao.BooktagRelationMapper;
import com.feimang.userstudy.dao.UserBookMapper;
import com.feimang.userstudy.dao.UserBookRemarkMapper;
import com.feimang.userstudy.pojo.BooktagRelation;
import com.feimang.userstudy.pojo.UserBook;
import com.feimang.userstudy.pojo.UserBookRemark;
import com.feimang.userstudy.service.IBookTagRelationService;
import com.feimang.userstudy.vo.BookTagRelationVo;
import com.feimang.userstudy.vo.BookTagRelations;
import com.feimang.userstudy.vo.UserBookVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yxm on 2018/2/3
 */
@Service("bookTagRelationService")
public class    BookTagRelationServiceImpl implements IBookTagRelationService{

    @Autowired
    private BooktagRelationMapper booktagRelationMapper;
    @Autowired
    private UserBookMapper userBookMapper;
    @Autowired
    private BookTagMapper bookTagMapper;
    @Autowired
    private UserBookRemarkMapper userBookRemarkMapper;
    //region 书架内图书操作
    /**
     * 获取书架内图书列表
     * @param utid 书架id
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse getBooksByBookTag(Long userId,Integer utid,int pageNum,int pageSize){
        if ( utid == null || userId ==null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);
        //查询
        List<BooktagRelation> booktagRelationList = booktagRelationMapper.getBooksByUTID(userId,utid);
        if (CollectionUtils.isNotEmpty(booktagRelationList)){
            List<BookTagRelationVo> bookTagRelationVos = new ArrayList<>();
            // 根据每本书的用户id和图书id查询备注
            for (BooktagRelation booktagRelation : booktagRelationList){
                BookTagRelationVo bookTagRelationVo = new BookTagRelationVo();
                bookTagRelationVo.setBookid(booktagRelation.getBookid());
                bookTagRelationVo.setCreatetime(booktagRelation.getCreatetime());
                bookTagRelationVo.setFromuid(booktagRelation.getFromuid());
                bookTagRelationVo.setId(booktagRelation.getId());
                bookTagRelationVo.setUtid(booktagRelation.getUtid());
                bookTagRelationVo.setTagbookseq(booktagRelation.getTagbookseq());
                UserBookRemark userBookRemark = userBookRemarkMapper.getRemarkByFromidAndBookID(booktagRelation.getFromuid(),booktagRelation.getBookid());
                if (userBookRemark!=null){
                    //该书含有备注
                    bookTagRelationVo.setUserBookRemark(userBookRemark);
                }
                bookTagRelationVos.add(bookTagRelationVo);
            }
            PageInfo pageInfo = new PageInfo(bookTagRelationVos);
            return ServerResponse.createBySuccess("查询成功",pageInfo);
        }
        return ServerResponse.createByErrorMessage("书架内没有图书");
    }

    /**
     * 书架内添加图书
     *
     * @param
     * @return
     */
    public ServerResponse addBookToBookTag(UserBookVO userBookVO){
        if ( CollectionUtils.isEmpty(userBookVO.getUserBooks())){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        if (userBookVO.getUtid()==null || userBookVO.getUtid()==0){//待分类图书
            for (UserBook userBook:userBookVO.getUserBooks()
                 ) {
                userBook.setIsTag(0);//设置为待分类图书
            }

        }else{
            // 已分类图书
            List<BooktagRelation> booktagRelations = (List<BooktagRelation>)CollectionUtils.collect(userBookVO.getUserBooks(), new Transformer() {
                @Override
                public Object transform(Object o) {
                    UserBook userBook = (UserBook)o;
                    BooktagRelation relation = new BooktagRelation();
                    relation.setBookid(userBook.getBookid());
                    relation.setFromuid(userBook.getFromuid());
                    relation.setUtid(userBookVO.getUtid());
                    return relation;
                }
            });
            // 向booktagrelation表中插入数据
            booktagRelationMapper.addBookToBookTag(booktagRelations);
            for (UserBook userBook:userBookVO.getUserBooks()
                    ) {
                userBook.setIsTag(1);// 已分类图书
            }
        }
        // 添加UserBooK
        userBookMapper.addUserBook(userBookVO.getUserBooks());
        //修改错误数据
        userBookMapper.checkError(userBookVO.getUserBooks().get(0).getFromuid());
        //修改UTID 对应TagCount
        bookTagMapper.updateTagCount(userBookVO.getUtid());
        return ServerResponse.createBySuccess("添加成功");
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
        // 修改userbook中的istag数据
        userBookMapper.checkError(booktagRelationList.get(0).getFromuid());
        // 更新booktag表中的该书架内存放图书的数量
        //修改UTID 对应TagCount
        bookTagMapper.updateTagCount(booktagRelationList.get(0).getUtid());
        return ServerResponse.createBySuccess("删除成功");

    }

    /**
     * 书架内复制图书
     * @param booktagRelationList
     * @return
     */
    public ServerResponse copyBook(List<BooktagRelation> booktagRelationList){
        if ( CollectionUtils.isEmpty(booktagRelationList)){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        //辅助图书 像booktagrelation表中添加
        booktagRelationMapper.addBookToBookTag(booktagRelationList);
        //更新书架内的图书数量 booktag的tagcount表
        bookTagMapper.updateTagCount(booktagRelationList.get(0).getUtid());
        return ServerResponse.createBySuccess("图书复制成功");
    }

    /**
     * 书架内移动图书
     * @param entity
     * @return
     */
    public ServerResponse moveBook(BookTagRelations entity){
        if ( entity == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        //删除书架内的图书
        booktagRelationMapper.delBookByUserIdAndId(entity.booktagRelations);
        //添加书架内的图书
        booktagRelationMapper.addBookToBookTag(entity.booktagRelations);
        //更新书架内的图书数量
        //更新被移动的书架图书数量
        bookTagMapper.updateTagCount(entity.fromUtid);
        //更新目标书架的图书数量
        bookTagMapper.updateTagCount(entity.toUtid);
        return ServerResponse.createBySuccess("移动图书成功");
    }

    /**
     * 书架内图书排序
     * @param booktagRelationList
     * @return
     */
    public ServerResponse editBookSeq(List<BooktagRelation> booktagRelationList){
        if ( CollectionUtils.isEmpty(booktagRelationList)){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        // 修改图书排序
        booktagRelationMapper.editBookSeq(booktagRelationList);
        return ServerResponse.createBySuccess("排序成功");
    }
    //endregion
}
