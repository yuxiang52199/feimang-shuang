package com.feimang.clubstudy.service.impl;

import com.feimang.clubstudy.common.ResponseCode;
import com.feimang.clubstudy.common.ServerResponse;
import com.feimang.clubstudy.dao.ActivityBooksMapper;
import com.feimang.clubstudy.dao.ActivityMapper;
import com.feimang.clubstudy.dao.ActivitySignUpMapper;
import com.feimang.clubstudy.pojo.Activity;
import com.feimang.clubstudy.pojo.ActivityBooks;
import com.feimang.clubstudy.pojo.ActivitySignUp;
import com.feimang.clubstudy.service.IActivityService;
import com.feimang.clubstudy.vo.ActivityDetails;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityService implements IActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private ActivitySignUpMapper activitySignUpMapper;

    @Autowired
    private ActivityBooksMapper activityBooksMapper;

    /**
     * 创建公告/活动
     * @Describe
     * @param details
     * @return  com.feimang.clubstudy.common.ServerResponse
     */
    public ServerResponse addActivity(ActivityDetails details){

        //参数为空
        if (details.getActivity() == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        Long caid=activityMapper.insertAndGetId(details.getActivity());


        if(details.getActivityBooks()!=null){
            for (ActivityBooks item :details.getActivityBooks()
             ) {
               item.setCaid(caid);
            }

            activityBooksMapper.insertByList(details.getActivityBooks());
        }
        return ServerResponse.createBySuccess("创建成功");
    }

    /**
     * 编辑公告/活动
     * @Describe
     * @param details
     * @return  com.feimang.clubstudy.common.ServerResponse
     */
    public ServerResponse editActivity(ActivityDetails details){

        //参数为空
        if (details.getActivity() == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        int resultCount=activityMapper.updateByPrimaryKeySelective(details.getActivity());

        if(details.getActivityBooks()!=null){
            activityBooksMapper.insertByList(details.getActivityBooks());
        }

        if (resultCount > 0){
            return ServerResponse.createBySuccess("编辑成功");
        }

        return ServerResponse.createBySuccessMessage("编辑失败");
    }
    /**
     * 删除公告/活动
     * @Describe
     * @param caid
     * @return  com.feimang.clubstudy.common.ServerResponse
     */
    public ServerResponse delActivity(Long caid){
        //参数为空
        if (caid == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        Activity activity = new Activity();
        activity.setCaid(caid);
        activity.setIsdelete(1);
        int resultCount=activityMapper.updateByPrimaryKeySelective(activity);

        if (resultCount > 0){
            return ServerResponse.createBySuccess("删除成功");
        }

        return ServerResponse.createBySuccessMessage("删除失败");
    }

    /**
     * 设置文章/公告置顶
     * @Describe
     * @param caid
     * @param IsTop
     * @return  com.feimang.clubstudy.common.ServerResponse
     */
    public ServerResponse setActivityIsTop(Long caid,int IsTop){

        //参数为空
        if (caid == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        Activity activity = new Activity();
        activity.setCaid(caid);
        activity.setIstop(IsTop);
        int resultCount=activityMapper.insertSelective(activity);

        if (resultCount > 0){
            return ServerResponse.createBySuccess("删除成功");
        }

        return ServerResponse.createBySuccessMessage("删除失败");
    }

    /**
     * 获取公告/活动列表
     * @Describe
     * @param clubId
     * @param pageNum
     * @param pageSize
     * @return  com.feimang.clubstudy.common.ServerResponse<com.github.pagehelper.PageInfo>
     */
    public ServerResponse<PageInfo> getActivitysByClubId(Long clubId,int pageNum,int pageSize){

        //参数为空
        if (clubId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        PageHelper.startPage(pageNum, pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("clubID",clubId);
        map.put("sort","IsTop");
        map.put("order","DESC");
        List<Activity> activities = activityMapper.selectListByMap(map);
        PageInfo pageResult = new PageInfo();
        pageResult.setList(activities);

        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 获取公告/活动详情
     * @Describe
     * @param caid
     * @return  com.feimang.clubstudy.common.ServerResponse<com.feimang.clubstudy.pojo.Activity>
     */
    public ServerResponse<ActivityDetails> getActivityDetails(Long caid){
        //参数为空
        if (caid == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        ActivityDetails details = new ActivityDetails();
        Activity activity = activityMapper.selectByPrimaryKey(caid);

        if(activity==null){
            return ServerResponse.createByErrorMessage("不存在公告/活动");
        }
        else{
            details.setActivity(activity);
        }

        List<ActivityBooks> activityBooks= activityBooksMapper.selectListByCaid(caid);
        details.setActivityBooks(activityBooks);

        return ServerResponse.createBySuccess(details);
    }

    /**
     * 获取报名参加活动的用户列表
     * @Describe
     * @param caid
     * @return  com.feimang.clubstudy.common.ServerResponse<com.github.pagehelper.PageInfo>
     */
    public ServerResponse<PageInfo> getActivitySigns(Long caid,int pageNum,int pageSize){
        //参数为空
        if (caid == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        PageHelper.startPage(pageNum, pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("caid",caid);

        List<ActivitySignUp> signUps = activitySignUpMapper.selectListByMap(map);
        PageInfo pageResult = new PageInfo(signUps);
        //pageResult.setList(activities);
        return ServerResponse.createBySuccess(pageResult);
    }





}
