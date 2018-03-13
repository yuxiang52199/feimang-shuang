package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.UserBookRecord;
import com.feimang.userstudy.pojo.UserBookRecordAtuser;

import java.util.List;

/**
 * Created by yxm on 2018/2/5
 */
public interface IUserBookRecordService {
    // 获取推荐图书
    ServerResponse getRecommendBooks(Long userId, int pageNum, int pageSize);
    // 判断是否推荐图书
    ServerResponse isRecommend(Long userId,Long bookId);
    // 添加推荐图书
    ServerResponse addRecommendBook(UserBookRecord userBookRecord);
    // 取消推荐图书
    ServerResponse delRecommendBook(List<UserBookRecord> userBookRecordList);
    // 编辑推荐信息
    ServerResponse editRecommendBook(UserBookRecord userBookRecord);
    // 分页获取书拍
    ServerResponse getBookPhotos(Long userId,int pageNum,int pageSize);
    // 删除书拍
    ServerResponse delBookPhoto(UserBookRecord userBookRecord);
    // 发布书拍
    ServerResponse addBookPhoto(UserBookRecord userBookRecord,List<UserBookRecordAtuser> userBookRecordAtusers);
    // 根据ids 获取推荐图书列表
    ServerResponse getRecommendBooksByIds(String ids);
    // 根据ids 获取书拍列表
    ServerResponse getBookPhotosByIds(String ids);
    // 获取被提醒的书拍
    ServerResponse getAtusers(Long touid,int pageNum,int pageSize);
    //测试
    ServerResponse ceshi();
}
