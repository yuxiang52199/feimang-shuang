package com.feimang.month.service.impl;
import com.feimang.month.common.ResponseCode;
import com.feimang.month.common.ServerResponse;
import com.feimang.month.dao.OrderBooksRelationMapper;
import com.feimang.month.dao.UserAbstructMapper;
import com.feimang.month.pojo.OrderBooksRelation;
import com.feimang.month.pojo.UserAbstruct;
import com.feimang.month.service.IUserService;
import com.feimang.month.vo.UserRDBVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserAbstructMapper userAbstructMapper;

    @Autowired
    private OrderBooksRelationMapper orderBooksRelationMapper;
    //用户注册
    public ServerResponse insertUserRegistration(UserAbstruct userAbstruct){

        if(userAbstruct.getUserid() == null || userAbstruct.getBirthdate()==null ||userAbstruct.getSex()==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        if(userAbstructMapper.selectByUserId(userAbstruct.getUserid())==null){
            return ServerResponse.createBySuccessMessage("已经注册");
        }
        userAbstructMapper.insertSelective(userAbstruct);

        return ServerResponse.createBySuccess();
    }
    //添加地址和修改地址
    public ServerResponse updateUserReceivingAddress(UserAbstruct userAbstruct){
        if(userAbstruct.getUserid() == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        userAbstructMapper.updateByPrimaryKeySelective(userAbstruct);

        return ServerResponse.createBySuccess();
    }
    //获取地址:?==》传值如何确定是userId还是uaId
    public ServerResponse getUserReceivingAddress(Long userId){
        if(userId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        UserAbstruct userAbstruct=userAbstructMapper.selectByPrimaryKey(userId);
        return ServerResponse.createBySuccess(userAbstruct);
    }

    //获取用户的阅读时间和本数

    public ServerResponse getUserReadsth(Long userId){
        if(userId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        UserRDBVo userRDBVo = new UserRDBVo();
        userRDBVo.setReadingBooks(orderBooksRelationMapper.selectBooksByUserId(userId));
        userRDBVo.setReadingDates(orderBooksRelationMapper.selectDaysByUserId(userId));
        userRDBVo.setUserAbstruct(userAbstructMapper.selectByUserId(userId));

        return ServerResponse.createBySuccess(userRDBVo);
    }
}
