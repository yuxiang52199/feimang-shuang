package com.feimang.book.controller;

import com.feimang.book.common.ServerResponse;
import com.feimang.book.pojo.BookInfo;
import com.feimang.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private IBookService bookService;

    /**
     * 手动录入添加图书
     * @Describe
     * @param book
     * @return  com.feimang.book.common.ServerResponse
     */
    @PostMapping("/AddBook_Input")
    public ServerResponse AddBook_Input(BookInfo book){
        return bookService.AddBook_Input(book);
    }

    /**
     * 获取图书列表
     * @Describe 通过Ids获取图书列表
     * @param bookIds
     * @return  ServerResponse< List< BookInfo>>
     */
    @GetMapping("/GetBooksByBookIds/{bookIds}")
    public ServerResponse<List<BookInfo>> GetBooksByBookIds(@PathVariable("bookIds") String bookIds) {
        return  bookService.GetBooksByBookIds(bookIds);
    }






}
