package com.feimang.userstudy.controller;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.UserBookRemark;
import com.feimang.userstudy.service.IUserBookRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yxm on 2018/2/8
 */
@RestController
public class UserBookRemarkController {
    @Autowired
    private IUserBookRemarkService userBookRemarkService;
    /**
     * 判断是否备注图书
     * @param request
     * @param fromuid
     * @param bookid
     * @return
     */
    @GetMapping("/isRemarkBook")
    public ServerResponse isRemarkBook(HttpServletRequest request,Long fromuid,Long bookid){
        return userBookRemarkService.isRemarkBook(fromuid,bookid);
    }

    /**
     * 获取备注图书列表
     * @param request
     * @param fromuid 用户id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getRemarkBooksByFromuid")
    public ServerResponse getRemarkBooksByFromuid(HttpServletRequest request, Long fromuid, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        return userBookRemarkService.getBookRemarksByFromuid(fromuid, pageNum, pageSize);
    }

    /**
     * 添加或修改备注
     * @param request
     * @param userBookRemark
     * @return
     */
    @PostMapping("/addOrupdateRemark")
    public ServerResponse addOrupdateRemark(HttpServletRequest request, UserBookRemark userBookRemark){
        return userBookRemarkService.addOrupdateRemark(userBookRemark);
    }
}
