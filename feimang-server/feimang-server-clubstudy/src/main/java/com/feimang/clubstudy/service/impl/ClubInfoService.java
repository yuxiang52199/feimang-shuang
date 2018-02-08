package com.feimang.clubstudy.service.impl;

import com.feimang.clubstudy.common.Const;
import com.feimang.clubstudy.common.ResponseCode;
import com.feimang.clubstudy.common.ServerResponse;
import com.feimang.clubstudy.dao.ClubInfoMapper;
import com.feimang.clubstudy.pojo.ClubInfo;
import com.feimang.clubstudy.service.IClubInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClubInfoService implements IClubInfoService {

    @Autowired
    private ClubInfoMapper clubinfoMapper;

    /**
     * 创建读书会
     * @Describe
     * @param clubinfo
     * @return  com.feimang.clubstudy.common.ServerResponse
     */
    public ServerResponse createClub(ClubInfo clubinfo){

        if (clubinfo == null ){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        //创建个人群书房，无需审核直接通过
        if(clubinfo.getClubtype()== Const.ClubType.INDIVIDUAL.getCode()){
            clubinfo.setClubstatus(Const.ClubStatus.SUCCESS.getCode());
        }

        int resultCount= clubinfoMapper.insertSelective(clubinfo);

        if (resultCount > 0){
            return ServerResponse.createBySuccess("创建成功");
        }
        return ServerResponse.createByErrorMessage("创建失败");
    }

    /**
     * 编辑读书会信息
     * @Describe
     * @param clubinfo
     * @return  com.feimang.clubstudy.common.ServerResponse
     */
    public ServerResponse editClub(ClubInfo clubinfo){

        //参数为空
        if (clubinfo == null ){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        int resultCount=clubinfoMapper.updateByPrimaryKeySelective(clubinfo);

        if (resultCount > 0){
            return ServerResponse.createBySuccess("编辑成功");
        }
        return ServerResponse.createByErrorMessage("编辑失败");
    }



}
