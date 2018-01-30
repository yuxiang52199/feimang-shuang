package com.feimang.book.service.impl;

import com.feimang.book.common.ResponseCode;
import com.feimang.book.common.ServerResponse;
import com.feimang.book.dao.BookInfoMapper;
import com.feimang.book.pojo.BookInfo;
import com.feimang.book.service.IBookService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("bookService")
public class BookService implements IBookService {
    @Autowired
    private BookInfoMapper bookInfoMapper;

    /**
     * 获取图书详情
     * @Describe
     * @param bookId
     * @return  com.feimang.book.common.ServerResponse<com.feimang.book.pojo.BookInfo>
     */
    public ServerResponse<BookInfo> GetBookInfoByBookId(Long bookId){


        if(bookId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        BookInfo bookInfo = bookInfoMapper.selectByPrimaryKey(bookId);
        if(bookInfo == null){
            return ServerResponse.createByErrorMessage("图书不存在");
        }
        if(bookInfo.getBookstatus() != 0){
            return ServerResponse.createByErrorMessage("图书不存在");
        }

        return ServerResponse.createBySuccess(bookInfo);
    }

    /**
     * 添加图书
     * @Describe
     * @param book
     * @return  com.feimang.book.common.ServerResponse
     */
    public ServerResponse AddBook(BookInfo book){
        if(book != null)
        {
            book.setIsapproved(0);
            int rowCount = bookInfoMapper.insertSelective(book);

            if(rowCount > 0){
                return ServerResponse.createBySuccess("添加图书成功");
            }
            return ServerResponse.createBySuccess("添加图书失败");
        }
        return ServerResponse.createByErrorMessage("图书信息不能为空");
    }

    /**
     * 手动录入添加图书
     * @Describe
     * @param book
     * @return  com.feimang.book.common.ServerResponse
     */
    public ServerResponse AddBook_Input(BookInfo book){

        if(book != null)
        {
            book.setIsapproved(1);
            int rowCount = bookInfoMapper.insertSelective(book);

            if(rowCount > 0){
                return ServerResponse.createBySuccess("添加图书成功");
            }
            return ServerResponse.createBySuccess("添加图书失败");
        }
        return ServerResponse.createByErrorMessage("图书信息不能为空");
    }

    /**
     * 获取图书列表
     * @Describe 通过Ids获取图书列表
     * @param bookIds
     * @return  ServerResponse< List< BookInfo>>
     */
    public ServerResponse<List<BookInfo>> GetBooksByBookIds(String bookIds){

        if(StringUtils.isBlank(bookIds)){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        List<String> bookIdList =  Arrays.asList(bookIds.split(","));
        List<BookInfo> bookList = bookInfoMapper.getBooksByBookIds(bookIdList);
        return ServerResponse.createBySuccess(bookList);

    }


}
