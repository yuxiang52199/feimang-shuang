package com.feimang.month.service.impl;

import com.feimang.month.common.Const;
import com.feimang.month.common.ResponseCode;
import com.feimang.month.common.ServerResponse;
import com.feimang.month.dao.*;
import com.feimang.month.pojo.Card;
import com.feimang.month.pojo.Order;
import com.feimang.month.pojo.OrderProductRelation;
import com.feimang.month.pojo.Product;
import com.feimang.month.service.IMonthReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        for(int i=1;i<=product.getCount();i++) {
            OrderProductRelation orderProductRelation = new OrderProductRelation();
            orderProductRelation.setUserid(userId);
            orderProductRelation.setOrderNumber(card.getMark());
            orderProductRelation.setRelationNumber(i);
            orderProductRelation.setRelationStatus(Const.RelationStatus.RelationStatus_NO.getCode());

            Long id= orderProductRelationMapper.insertSelective(orderProductRelation);
            //选取书并插入到Order_Books_Relation
        }

        return ServerResponse.createBySuccessMessage("已成功");
    }
    //endregion

}
