package com.feimang.clubstudy.service.impl;

import com.feimang.clubstudy.common.Const;
import com.feimang.clubstudy.common.ResponseCode;
import com.feimang.clubstudy.common.ServerResponse;
import com.feimang.clubstudy.dao.*;
import com.feimang.clubstudy.pojo.*;
import com.feimang.clubstudy.service.IMemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MemberService implements IMemberService {

    @Autowired
    private ClubInfoMapper clubinfoMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MemberPowerMapper memberPowerMapper;

    @Autowired
    private MemberPowerRelationMapper memberPowerRelationMapper;

    @Autowired
    private MemberApplyMapper memberApplyMapper;


    //region 群书房会员管理
    /**
     * 加入群书房
     * @Describe
     * @param userId
     * @param clubId
     * @param passWord
     * @return  com.feimang.clubstudy.common.ServerResponse
     */
    public ServerResponse addClubMember(Long userId,Long clubId,String passWord){

        //参数为空
        if (userId == null ||clubId==null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ClubInfo club =clubinfoMapper.selectByPrimaryKey(clubId);
        if(club==null){
            return ServerResponse.createByErrorMessage("读书会不存在");
        }

        Member member = new Member();
        member.setClubid(clubId);
        member.setFromuid(userId);
        memberMapper.insertSelective(member);

        //region  读书会加入权限判断
//        if(club.getJointype()== Const.ClubJoinType.ALL.getCode()){
//            memberMapper.insertSelective(member);
//        }
//        else if(club.getJointype()== Const.ClubJoinType.PASSWORD.getCode()){
//            if(club.getJoinpassword()==passWord){
//                memberMapper.insertSelective(member);
//            }
//            else{
//                return ServerResponse.createByErrorMessage("密码错误");
//            }
//
//        }
//        else if (club.getJointype()== Const.ClubJoinType.INVITATION.getCode()){
//
//        }
        //endreigon

        return ServerResponse.createBySuccessMessage("加入成功");

    }

    /**
     * 获取我加入的群书房列表
     * @Describe
     * @param userId
     * @return  com.feimang.clubstudy.common.ServerResponse<java.util.List<com.feimang.clubstudy.pojo.Member>>
     */
    public ServerResponse<List<Member>> getMyClubList(Long userId){

        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("fromuid",userId);
        map.put("isRemove", Const.MemberIsRemove.NO.getCode());
        map.put("sort","MemberID");
        map.put("order","desc");

        List<Member> members = memberMapper.getMemberListByMap(map);

        return ServerResponse.createBySuccess(members);
    }

    /**
     * 获取群书房管理员列表
     * @Describe
     * @param clubId
     * @return  com.feimang.clubstudy.common.ServerResponse<java.util.List<com.feimang.clubstudy.pojo.Member>>
     */
    public ServerResponse<List<Member>> getAdminsByClubId(Long clubId){


        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("clubid",clubId);
        map.put("isRemove", Const.MemberIsRemove.NO.getCode());
        map.put("memberType", Const.MemberType.ADMIN);
        List<Member> members = memberMapper.getMemberListByMap(map);

        map.remove("memberType");
        map.put("memberType", Const.MemberType.CREATOR);
        members.containsAll(memberMapper.getMemberListByMap(map));

        return ServerResponse.createBySuccess(members);
    }

    /**
     * 获取群书房移除/未移除成员列表
     * @Describe
     * @param clubId
     * @param pageNum
     * @param pageSize
     * @return  com.feimang.clubstudy.common.ServerResponse<com.github.pagehelper.PageInfo>
     */
    public ServerResponse<PageInfo> getMembersByClubId(Long clubId,int isRemove,int pageNum,int pageSize){

        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("clubid",clubId);
        map.put("isRemove", isRemove);
        map.put("memberType", Const.MemberType.GENERAL);
        map.put("sort","MemberID");
        map.put("order","desc");

        PageHelper.startPage(pageNum, pageSize);
        List<Member> members = memberMapper.getMemberListByMap(map);

        PageInfo pageResult = new PageInfo();
        pageResult.setList(members);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 获取群书房指定/未指定发书拍用户
     * @Describe
     * @param clubId
     * @param pageNum
     * @param pageSize
     * @return  com.feimang.clubstudy.common.ServerResponse<com.github.pagehelper.PageInfo>
     */
    public ServerResponse<PageInfo> getMembersByIsCreatePhoto(Long clubId,int isCreatePhoto,int pageNum,int pageSize){

        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("clubid",clubId);
        map.put("isRemove", Const.MemberIsRemove.NO.getCode());//未移除
        map.put("isCreatePhoto", isCreatePhoto);//已指定
        map.put("isForbidPhoto", Const.MemberIsForbidPhoto.NO.getCode());//未禁止
        map.put("sort","MemberID");
        map.put("order","desc");

        PageHelper.startPage(pageNum, pageSize);
        List<Member> members = memberMapper.getMemberListByMap(map);

        PageInfo pageResult = new PageInfo();
        pageResult.setList(members);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 获取禁止/未禁止发书拍名单
     * @Describe
     * @param clubId
     * @param isForbidPhoto
     * @param pageNum
     * @param pageSize
     * @return  com.feimang.clubstudy.common.ServerResponse<com.github.pagehelper.PageInfo>
     */
    public ServerResponse<PageInfo> getMembersByIsForbidPhoto(Long clubId,int isForbidPhoto, int pageNum,int pageSize){

        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("clubid",clubId);
        map.put("isRemove", Const.MemberIsRemove.NO.getCode());//未移除
        map.put("isForbidPhoto", isForbidPhoto);
        map.put("sort","MemberID");
        map.put("order","desc");

        PageHelper.startPage(pageNum, pageSize);
        List<Member> members = memberMapper.getMemberListByMap(map);

        PageInfo pageResult = new PageInfo();
        pageResult.setList(members);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 设置成员状态
     * @Describe
     * @param members
     * @return  com.feimang.clubstudy.common.ServerResponse
     */
    public ServerResponse SetMember(List<Member> members){

        //参数为空
        if (members == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        for (Member member:members
             ) {
            memberMapper.updateByPrimaryKeySelective(member);

        }
        return ServerResponse.createBySuccess("设置成功");
    }

    /**
     * 设置管理员并赋予权限
     * @Describe
     * @param relations
     * @return  com.feimang.clubstudy.common.ServerResponse
     */
    public ServerResponse SetAdmin(List<MemberPowerRelation> relations){
        //参数为空
        if (relations == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Long memberId=relations.get(0).getMemberid();

        //region 设置管理员
        Member member = new Member();
        member.setMemberid(memberId);
        member.setMembertype(Const.MemberType.ADMIN.getCode());
        memberMapper.updateByPrimaryKeySelective(member);
        //endregion

        //region 删除原有权限
        memberPowerRelationMapper.deleteByMemberId(memberId);
        //endregion

        //region 设置新的权限
        for (MemberPowerRelation relation:relations
             ) {
            memberPowerRelationMapper.updateByPrimaryKeySelective(relation);
        }

        //endregion

        return ServerResponse.createBySuccess("设置成功");
    }

    //endregion

    //region 群书房申请管理

    //申请加入读书会

    /**
     * 获取群书房申请未审核数量
     * @Describe
     * @param clubId
     * @return  com.feimang.clubstudy.common.ServerResponse<java.lang.Integer>
     */
    public ServerResponse<Integer> getMemberApplyCount(Long clubId){

        //参数为空
        if (clubId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("clubid",clubId);
        map.put("isexamine", Const.MemberApplyIsExamine.PROGRESS.getCode());
        Integer applyCount=memberApplyMapper.selectCountByMap(map);

        return ServerResponse.createBySuccess(applyCount);

    }

    /**
     * 获取群书房申请未审核列表
     * @Describe
     * @param clubId
     * @param pageNum
     * @param pageSize
     * @return  com.feimang.clubstudy.common.ServerResponse<com.github.pagehelper.PageInfo>
     */
    public ServerResponse<PageInfo> getMemberApplyList(Long clubId,int pageNum,int pageSize){

        //参数为空
        if (clubId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("clubid",clubId);
        map.put("isexamine", Const.MemberApplyIsExamine.PROGRESS.getCode());
        PageHelper.startPage(pageNum, pageSize);
        List<MemberApply> applies=memberApplyMapper.selectListByMap(map);

        PageInfo pageResult = new PageInfo(applies);

        return ServerResponse.createBySuccess(pageResult);

    }

    /**
     * 审核加入群书房申请信息
     * @Describe
     * @param memberApply
     * @return  com.feimang.clubstudy.common.ServerResponse
     */
    public ServerResponse examineMemberApply(MemberApply memberApply){
        //参数为空
        if (memberApply == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
//        MemberApply memberApply = new MemberApply();
//        memberApply.setApplyid(applyId);
        memberApply.setExaminetime(new Date());

        int resultCount = memberApplyMapper.updateByPrimaryKeySelective(memberApply);

        if(resultCount>0){
            return ServerResponse.createBySuccessMessage("审核成功");
        }

        return ServerResponse.createByErrorMessage("审核失败");

    }

    //endregion



}
