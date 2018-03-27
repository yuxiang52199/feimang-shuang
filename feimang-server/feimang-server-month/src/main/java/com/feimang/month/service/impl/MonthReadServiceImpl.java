package com.feimang.month.service.impl;

import com.feimang.month.common.Const;
import com.feimang.month.common.ResponseCode;
import com.feimang.month.common.ServerResponse;
import com.feimang.month.dao.*;
import com.feimang.month.pojo.*;
import com.feimang.month.service.IMonthReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("monthReadService")
public class MonthReadServiceImpl implements IMonthReadService {

    //region 成员变量
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderProductRelationMapper orderProductRelationMapper;

    @Autowired
    private OrderBooksRelationMapper orderBooksRelationMapper;

    @Autowired
    private UserKlMapper userKlMapper;
    //endregion

    //region 订单模块
    /**
     * 验证兑换卡卡号
     * @param userId
     * @param mark
     * @return  com.feimang.month.common.ServerResponse
     */
    public ServerResponse validateCard(Long userId,String mark){


        if(mark == null){
            return ServerResponse.createByErrorMessage("卡号不能为空");
        }
        Card card = cardMapper.selectByMark(mark);
        if(card==null){
            return ServerResponse.createByErrorMessage("此卡号不存在");
        }
        if(card.getStatus()== Const.CardStatus.CARD_YES.getCode()){
            return ServerResponse.createByErrorMessage("此卡号已经被激活");
        }
        Product product=productMapper.selectByPrimaryKey(card.getId());

        //创建订单信息
        Order order = new Order();
        order.setOrderNumber(card.getMark());
        order.setPlatformNumber(card.getMark());
        order.setProductid(card.getPid());
        order.setPlatformStatus(Const.PlatformStatus.PlatformStatus_YES.getCode());
        order.setPayPlatform(Const.PlatformType.PlatformType_CARD.getCode());
        order.setUserid(userId);
        orderMapper.insertSelective(order);

        //生成次数数据
//        for(int i=1;i<=product.getCount();i++) {
//            OrderProductRelation orderProductRelation = new OrderProductRelation();
//            orderProductRelation.setUserid(userId);
//            orderProductRelation.setOrderNumber(card.getMark());
//            orderProductRelation.setRelationNumber(i);
//            orderProductRelation.setRelationStatus(Const.ProductRelationStatus.RelationStatus_NO.getCode());
//
//            Long id= orderProductRelationMapper.insertSelective(orderProductRelation);
//            //选取书并插入到Order_Books_Relation
//        }

        return ServerResponse.createBySuccessMessage("已成功");
    }


    public ServerResponse getMyReadingPlan(Long userId) {
        if(userId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        HashMap map=new HashMap();
        map.put("userid",userId);
        map.put("platformStatus",Const.PlatformStatus.PlatformStatus_YES.getCode());//已支付状态 代表未完成
        Order order= orderMapper.selectByMap(map);
        List<OrderProductRelation> orderProductRelations = orderProductRelationMapper.selectListByOrderNumber(order.getOrderNumber());

        return ServerResponse.createBySuccess(orderProductRelations);

    }


    /**
     * 换一批
     * @param oPRelationid
     * @return  com.feimang.month.common.ServerResponse
     */
    public ServerResponse generateBooks(Long oPRelationid){

        if(oPRelationid == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        //查询书单
        OrderProductRelation orderProductRelation= orderProductRelationMapper.selectByPrimaryKey(oPRelationid);
        Long userId= orderProductRelation.getUserid();

        //查询用户选择的生成计划方向
        UserKl userKl =userKlMapper.selectByUserId(userId);
        if(userKl.getFlg()==Const.KLFlg.KL_LENGTH.getCode()){

        }
        else if(userKl.getFlg()==Const.KLFlg.KL_SHORT.getCode()){

        }
        else if(userKl.getFlg()==Const.KLFlg.KL_CUSTOM.getCode()){

        }


        return ServerResponse.createBySuccessMessage("换一批成功");
    }

    /**
     * 确定本次生成计划书单
     * @param oPRelationid
     * @return  com.feimang.month.common.ServerResponse
     */
    public ServerResponse ConfirmOrderProduct(Long oPRelationid){

        if(oPRelationid == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        OrderProductRelation orderProductRelation = new OrderProductRelation();
        orderProductRelation.setoPRelationid(oPRelationid);
        orderProductRelation.setRelationStatus(Const.ProductRelationStatus.RelationStatus_YES.getCode());

        return ServerResponse.createBySuccessMessage("设置成功");
    }

    /**
     * 设置完成本次计划书单
     * @param oPRelationid
     * @return  com.feimang.month.common.ServerResponse
     */
    public ServerResponse CompleteOrderProduct(Long oPRelationid){

        if(oPRelationid == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        OrderProductRelation orderProductRelation = new OrderProductRelation();
        orderProductRelation.setoPRelationid(oPRelationid);
        orderProductRelation.setRelationStatus(Const.ProductRelationStatus.RelationStatus_COMPLETE.getCode());

        return ServerResponse.createBySuccessMessage("设置成功");
    }
    /**
     * 设置正在读状态
     * @param oBRelationid
     * @return  com.feimang.month.common.ServerResponse
     */
    public ServerResponse SetReadingBookStatus(Long oBRelationid){

        if(oBRelationid == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        OrderBooksRelation orderBooksRelation = new OrderBooksRelation();
        orderBooksRelation.setoBRelationid(oBRelationid);
        orderBooksRelation.setRelationStatus(Const.BookRelationStatus.RelationStatus_READING.getCode());
        return ServerResponse.createBySuccessMessage("设置成功");
    }

    /**
     * 设置已读完状态
     * @param oBRelationid
     * @return  com.feimang.month.common.ServerResponse
     */
    public ServerResponse SetReadBookStatus(Long oBRelationid){
        if(oBRelationid == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        OrderBooksRelation orderBooksRelation = new OrderBooksRelation();
        orderBooksRelation.setoBRelationid(oBRelationid);
        orderBooksRelation.setRelationStatus(Const.BookRelationStatus.RelationStatus_READ.getCode());
        return ServerResponse.createBySuccessMessage("设置成功");
    }

    //endregion

}
