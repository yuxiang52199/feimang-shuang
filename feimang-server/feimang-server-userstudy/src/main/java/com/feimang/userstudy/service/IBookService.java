package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.BookInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("eureka-book-server")
public interface IBookService {

    @GetMapping("/GetBooksByBookIds/{bookIds}")
    ServerResponse<List<BookInfo>> GetBooksByBookIds(@PathVariable("bookIds") String bookIds);
}
