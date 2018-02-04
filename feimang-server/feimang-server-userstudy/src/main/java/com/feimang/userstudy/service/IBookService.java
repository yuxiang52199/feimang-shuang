package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.BookInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by yxm on 2018/1/31
 */
@FeignClient("eureka-user-server")
public interface IBookService {
    /**
     * 手动录入添加图书
     * @Describe
     * @param book
     * @return  com.feimang.book.common.ServerResponse
     */
    @PostMapping("/addBook_Input")
    ServerResponse addBook_Input(BookInfo book);

    /**
     * 获取图书列表
     * @Describe 通过Ids获取图书列表
     * @param bookIds
     * @return  ServerResponse< List< BookInfo>>
     */
    @GetMapping("/getBooksByBookIds")
    ServerResponse<List<BookInfo>> getBooksByBookIds(@PathVariable("bookIds") String bookIds);
}
