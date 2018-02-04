package com.feimang.book.service;

import com.feimang.book.common.ResponseCode;
import com.feimang.book.common.ServerResponse;
import com.feimang.book.pojo.BookInfo;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public interface IBookService {

    ServerResponse<BookInfo> getBookInfoByBookId(Long bookId);

    ServerResponse addBook(BookInfo book);

    ServerResponse addBook_Input(BookInfo book);

    ServerResponse<List<BookInfo>> getBooksByBookIds(String bookIds);

}
