package com.feimang.book.service;

import com.feimang.book.common.ResponseCode;
import com.feimang.book.common.ServerResponse;
import com.feimang.book.pojo.BookInfo;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public interface IBookService {

    ServerResponse<BookInfo> GetBookInfoByBookId(Long bookId);

    ServerResponse AddBook(BookInfo book);

    ServerResponse AddBook_Input(BookInfo book);

    ServerResponse<List<BookInfo>> GetBooksByBookIds(String bookIds);

}
