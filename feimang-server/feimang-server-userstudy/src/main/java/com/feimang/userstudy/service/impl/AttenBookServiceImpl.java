package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.UserBookAttenMapper;
import com.feimang.userstudy.pojo.BookInfo;
import com.feimang.userstudy.pojo.UserBookAtten;
import com.feimang.userstudy.service.IAttenBookService;
import com.feimang.userstudy.service.IBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
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
    private IBookService bookService;
    //region 图书关注相关
    /**
     * 添加图书关注
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    public ServerResponse addAttenByUserIdAndBookId(Long userId,Integer bookId){
        if (userId == null || bookId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ServerResponse serverResponse = isAttenBook(userId,bookId); //判断图书是否被关注
        if (serverResponse.isSuccess()){
            //图书已被关注
            return ServerResponse.createByErrorMessage("图书已被关注,关注失败");
        }
        // 插入数据
        UserBookAtten userBookAtten = new UserBookAtten();
        userBookAtten.setFromuid(userId);
        userBookAtten.setBookid(Long.valueOf(bookId));
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
    public ServerResponse getAttenBooks(Long userId, int pageNum,int pageSize){
        if (userId == null){
            // 判断参数是否为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);//分页查询
        List<UserBookAtten> userBookAttens = userBookAttenMapper.getAttendBooksByUserId(userId);
        String bookIds = String.join(",",CollectionUtils.collect(userBookAttens, new Transformer() {
            public Object transform(Object arg0) {
                UserBookAtten u = (UserBookAtten) arg0;
                return u.getBookid().toString();
            }
        }));

        List<BookInfo> books= bookService.getBooksByBookIds(bookIds).getData();
        //todo 查询图书详细信息
        for (UserBookAtten bookAtten:userBookAttens) {

            List<BookInfo> ss = (List<BookInfo>) CollectionUtils.select(books, new Predicate() {
                @Override
                public boolean evaluate(Object o) {
                    BookInfo book = (BookInfo)o;
                    return bookAtten.getBookid().equals(book.getBookid());
                }
            });
            bookAtten.setBook(ss.get(0));

        }
        if (CollectionUtils.isNotEmpty(userBookAttens)){
            PageInfo pageInfo = new PageInfo(userBookAttens);
            return ServerResponse.createBySuccess(pageInfo);
        }
        return ServerResponse.createByErrorMessage("用户还未关注过任何图书");
    }

    /**
     * 判断是否关注图书
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    public ServerResponse isAttenBook(Long userId,Integer bookId){
        if (userId == null || bookId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        UserBookAtten userBookAtten = userBookAttenMapper.isAttenBookByUserIDAndBookID(userId, bookId);
        if (userBookAtten == null){
            return ServerResponse.createByErrorMessage("图书尚未被关注");
        }
        return ServerResponse.createBySuccess("图书已被关注",userBookAtten);
    }

    /**
     * 删除关注的图书
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    public ServerResponse delAtten(Long userId,Integer bookId){
        if (userId == null || bookId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        int resultCount = userBookAttenMapper.delAttenByUserIdAndBookId(userId, bookId);
        if (resultCount > 0){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }
    //endregion
}
