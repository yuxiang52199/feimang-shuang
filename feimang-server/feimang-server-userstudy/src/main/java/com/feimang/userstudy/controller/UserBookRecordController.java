package com.feimang.userstudy.controller;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.UserBookRecord;
import com.feimang.userstudy.pojo.UserBookRecordAtuser;
import com.feimang.userstudy.service.IUserBookRecordService;
import com.feimang.userstudy.vo.UserBookRecords;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yxm on 2018/2/5
 */
@RestController
public class UserBookRecordController {
    @Autowired
    private IUserBookRecordService userBookRecordService;
    /**
     * 获取推荐列表
     * @param request
     * @param userId 用户id
     * @param pageNum 第几页
     * @param pageSize 每页几条
     * @return
     */
    @GetMapping("/getRecommendBooks")
    public ServerResponse getRecommendBooks(HttpServletRequest request, Long userId, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam(value = "pageNum",defaultValue = "1")int pageSize){
        return userBookRecordService.getRecommendBooks(userId, pageNum, pageSize);
    }

    /**
     * 判断是否推荐
     * @param request
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    @GetMapping("/isRecommend")
    public ServerResponse isRecommend(HttpServletRequest request,Long userId,Long bookId){
        return userBookRecordService.isRecommend(userId, bookId);
    }

    /**
     * 添加图书推荐
     * @param request
     * @param userBookRecord 推荐图书实体
     * @return
     */
    @PostMapping("/addRecommendBooK")
    public ServerResponse addRecommendBooK(HttpServletRequest request, UserBookRecord userBookRecord){
        return userBookRecordService.addRecommendBook(userBookRecord);
    }

    /**
     * 取消图书推荐
     * @param request
     * @param
     * @return
     */
    @PostMapping("/delRecommendBook")
    public ServerResponse delRecommendBook(HttpServletRequest request, @RequestBody UserBookRecords entity){
        return userBookRecordService.delRecommendBook(entity.userBookRecords);
    }

    /**
     * 编辑推荐信息
     * @param request
     * @param userBookRecord
     * @return
     */
    @PutMapping("/editRecommendBook")
    public ServerResponse editRecommendBook(HttpServletRequest request,UserBookRecord userBookRecord){
        return userBookRecordService.editRecommendBook(userBookRecord);
    }

    /**
     * 获取所有书拍
     * @param request
     * @param userId
     * @return
     */
    @GetMapping("/getBookPhotos")
    public ServerResponse getBookPhotos(HttpServletRequest request,Long userId,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam(value = "pageNum",defaultValue = "1")int pageSize){
        return userBookRecordService.getBookPhotos(userId, pageNum, pageSize);
    }

    /**
     * 删除书拍
     * @param request
     * @param userBookRecord
     * @return
     */
    @DeleteMapping("/delBookPhoto")
    public ServerResponse delBookPhoto(HttpServletRequest request,UserBookRecord userBookRecord){
        return userBookRecordService.delBookPhoto(userBookRecord);
    }

    /**
     * 发布书拍
     * @param request
     * @param userBookRecord
     * @return
     */
    @PostMapping("/addBookPhoto")
    public ServerResponse addBookPhoto(HttpServletRequest request, UserBookRecord userBookRecord, List<UserBookRecordAtuser> userBookRecordAtusers){
        return userBookRecordService.addBookPhoto(userBookRecord,userBookRecordAtusers);
    }

    /**
     * 根据ids获取推荐图书列表
     * @param request
     * @param ids
     * @return
     */
    @GetMapping("/getRecommendBooksByIds")
    public ServerResponse getRecommendBooksByIds(HttpServletRequest request,String ids){
        return userBookRecordService.getRecommendBooksByIds(ids);
    }

    /**
     * 根据ids获取书拍列表
     * @param request
     * @param ids
     * @return
     */
    @GetMapping("/getBookPhotosByIds")
    public ServerResponse getBookPhotosByIds(HttpServletRequest request,String ids){
        return userBookRecordService.getBookPhotosByIds(ids);
    }

    /**
     * 获取用户被@的书拍
     * @param request
     * @param touid
     * @return
     */
    @GetMapping("/getAtusers")
    public ServerResponse getAtusers(HttpServletRequest request,Long touid,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam(value = "pageNum",defaultValue = "1")int pageSize){
        return userBookRecordService.getAtusers(touid, pageNum, pageSize);
    }

    @PostMapping("/ceshi11")
    public ServerResponse ceshi111(HttpServletRequest request){
        return userBookRecordService.ceshi();
    }


}
