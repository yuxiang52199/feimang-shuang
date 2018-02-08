package com.feimang.clubstudy.service.impl;

import com.feimang.clubstudy.common.ResponseCode;
import com.feimang.clubstudy.common.ServerResponse;
import com.feimang.clubstudy.dao.BankCardMapper;
import com.feimang.clubstudy.dao.PayOrderMapper;
import com.feimang.clubstudy.pojo.BankCard;
import com.feimang.clubstudy.service.IPayOrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class PayOrderService implements IPayOrderService {

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private BankCardMapper bankCardMapper;

    //region 绑定银行卡
    /**
     * 获取绑定的银行信息
     * @Describe
     * @param clubId
     * @return  com.feimang.clubstudy.common.ServerResponse
     */
    public ServerResponse getBackCar(Long clubId){
        //参数为空
        if(clubId==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        BankCard bankCard = bankCardMapper.selectByClubId(clubId);

        return ServerResponse.createBySuccess(bankCard);
    }

    /**
     * 设置绑定银行卡信息
     * @Describe
     * @param bankCard
     * @return  com.feimang.clubstudy.common.ServerResponse
     */
    public ServerResponse setBackCard(BankCard bankCard){

        //参数为空
        if(bankCard==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        if(bankCard.getCbcid()==null){
            bankCardMapper.insertSelective(bankCard);
        }
        else {
            bankCardMapper.updateByPrimaryKeySelective(bankCard);
        }
        return ServerResponse.createBySuccessMessage("设置成功");

    }

    //endregion

    //region  群书房订单



    //endregion


}
