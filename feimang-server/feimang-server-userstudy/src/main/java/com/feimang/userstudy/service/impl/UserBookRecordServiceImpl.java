package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.Const;
import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.ContentBaseMapper;
import com.feimang.userstudy.dao.UserBookRecordAtuserMapper;
import com.feimang.userstudy.dao.UserBookRecordImageMapper;
import com.feimang.userstudy.dao.UserBookRecordMapper;
import com.feimang.userstudy.pojo.ContentBase;
import com.feimang.userstudy.pojo.UserBookRecord;
import com.feimang.userstudy.pojo.UserBookRecordAtuser;
import com.feimang.userstudy.pojo.UserBookRecordImage;
import com.feimang.userstudy.service.IUserBookRecordService;
import com.feimang.userstudy.vo.UserBookRecordAtuserVO;
//import com.feimang.userstudy.vo.UserBookRecordVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yxm on 2018/2/5
 */
@Service("userBookRecordService")
public class UserBookRecordServiceImpl implements IUserBookRecordService {

    @Autowired
    private UserBookRecordImageMapper userBookRecordImageMapper;
    @Autowired
    private UserBookRecordMapper userBookRecordMapper;
    @Autowired
    private ContentBaseMapper contentBaseMapper;
    @Autowired
    private UserBookRecordAtuserMapper userBookRecordAtuserMapper;
    //region 推荐图书相关
    /**
     * 获取推荐列表
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse getRecommendBooks(Long userId,int pageNum,int pageSize){
        if (userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        // 根据用户id分页查询 用户推荐列表
        PageHelper.startPage(pageNum, pageSize);
        List<UserBookRecord> userBookRecordList = userBookRecordMapper.getRecommendBooksByUserID(userId);
        if (CollectionUtils.isNotEmpty(userBookRecordList)){
            PageInfo pageInfo = new PageInfo(userBookRecordList);
            return ServerResponse.createBySuccess("获取成功",pageInfo);
        }
        return ServerResponse.createByErrorMessage("用户还未推荐图书");
    }

    /**
     * 判断是否推荐图书
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    public ServerResponse isRecommend(Long userId,Long bookId){
        if (userId == null || bookId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        // 根据用户id和图书id 查询是否存在
        UserBookRecord userBookRecord = userBookRecordMapper.selectByUserIdAndBookId(userId, bookId);
        if (userBookRecord != null){
            return ServerResponse.createBySuccess("该图书已推荐",userBookRecord);
        }
        return ServerResponse.createByErrorMessage("该图书尚未推荐");
    }

    /**
     * 添加推荐图书
     * @param userBookRecord
     * @return
     */
    public ServerResponse addRecommendBook(UserBookRecord userBookRecord){
        if (userBookRecord == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        // 判断图书是否被推荐
        ServerResponse serverResponse = isRecommend(userBookRecord.getFromuid(),userBookRecord.getBookid());
        if (serverResponse.isSuccess()){
            Object obj =serverResponse.getData();
            UserBookRecord userBookRecord1 = (UserBookRecord) obj;
            userBookRecord1.setDelflg(Const.BookTagDelFlg.UNDELETED.getCode());
            userBookRecordMapper.updateByPrimaryKeySelective(userBookRecord1);
            return ServerResponse.createByErrorMessage("图书已推荐");
        }
        userBookRecord.setDelflg(Const.BookTagDelFlg.UNDELETED.getCode());
        userBookRecord.setPhototype(Const.PhotoType.Recommend.getCode());
        userBookRecordMapper.insert(userBookRecord);
        return ServerResponse.createBySuccess("添加推荐成功");
    }

    /**
     * 取消图书推荐
     * @param
     * @return
     */
    public ServerResponse delRecommendBook(List<UserBookRecord> userBookRecordList){
        if (CollectionUtils.isEmpty(userBookRecordList)){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        //逻辑删除 更改delfal为1
        for (UserBookRecord userBookRecord : userBookRecordList){
            userBookRecord.setDelflg(Const.BookTagDelFlg.DELETED.getCode());
        }
        int resultCount = userBookRecordMapper.updateDelflgById(userBookRecordList);
        if (resultCount >0){
            return ServerResponse.createBySuccess("取消推荐成功");
        }
        return ServerResponse.createByErrorMessage("取消推荐失败");
    }

    /**
     * 编辑推荐信息
     * @param userBookRecord
     * @return
     */
    public ServerResponse editRecommendBook(UserBookRecord userBookRecord){
        if (userBookRecord == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ServerResponse serverResponse = isRecommend(userBookRecord.getFromuid(),userBookRecord.getBookid());
        if (serverResponse.isSuccess()){
            // 被推荐过
            Object obj = serverResponse.getData();
            UserBookRecord userBookRecord1 = (UserBookRecord) obj;
            if (userBookRecord1.getDelflg() == Const.BookTagDelFlg.DELETED.getCode()){
                return ServerResponse.createByErrorMessage("推荐图书已被删除 更新失败");
            }
            userBookRecordMapper.updateByPrimaryKeySelective(userBookRecord);
            return ServerResponse.createBySuccess("修改推荐成功");
        }
        return ServerResponse.createByErrorMessage("图书未被推荐");
    }
    //endregion
    //region 书拍相关
    /**
     * 分页获取书拍
     * @param userId 用户id
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse getBookPhotos(Long userId,int pageNum,int pageSize){
        if (userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);
        // 查询出书拍信息
        List<UserBookRecord> userBookRecordList = userBookRecordMapper.getBookPhotos(userId);
        // 根据书拍信息 查询书拍的图片
        List<UserBookRecordImage> userBookRecordImageList = userBookRecordImageMapper.getImageByRecordId(userBookRecordList);
        //UserBookRecordVO userBookRecordVO = new UserBookRecordVO();
        //todo 组合VO
        return ServerResponse.createBySuccess("查询成功",userBookRecordList);
    }

    /**
     * 删除书拍
     * @param userBookRecord
     * @return
     */
    public ServerResponse delBookPhoto(UserBookRecord userBookRecord){
        if (userBookRecord == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        //修改书拍的状态值为已删除
        userBookRecordMapper.updateBookPhotoDelflgByRecordID(userBookRecord.getRecordid());
        //修改书拍的图片状态为已删除 (写一个存储过程)
        userBookRecordImageMapper.updateDelflgByBookIdAndUserIdAndRecordID(userBookRecord.getBookid(),userBookRecord.getFromuid(),userBookRecord.getRecordid());
        return ServerResponse.createBySuccess("删除成功");
    }

    /**
     * 发布书拍 + @提醒谁看
     * @param userBookRecord
     * @return
     */
    public ServerResponse addBookPhoto(UserBookRecord userBookRecord,List<UserBookRecordAtuser> userBookRecordAtusers){
        if (userBookRecord == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        // fm_content_base插入数据 返回主键 并放入到userBookRecord 插入数据
        ContentBase contentBase = new ContentBase();
        contentBase.setCollectioncount(0);//收藏数量
        contentBase.setLikecount(0);//点赞数量
        contentBase.setPhototype(Const.PhotoType.BookPhoto.getCode());//状态为书拍
        contentBase.setRewcount(0);
        contentBase.setSharecount(0);//分享数量
        //todo 插入数据 并返回主键
        //contentBaseMapper.insert(contentBase); 然后将主键放入实体
        userBookRecord.setDelflg(Const.BookTagDelFlg.UNDELETED.getCode());
        userBookRecord.setPhototype(Const.PhotoType.BookPhoto.getCode());
        int id = userBookRecordMapper.insert(userBookRecord);
        //todo 设置插入返回主键,拿到主键 再做插入
        // @的人
        if (CollectionUtils.isNotEmpty(userBookRecordAtusers)){
            //插入@人的数据 提醒谁看,
            for (UserBookRecordAtuser userBookRecordAtuser : userBookRecordAtusers){
                userBookRecordAtuser.setStatus(0);
                userBookRecordAtuser.setRecordid(Long.valueOf(id));
            }
            userBookRecordAtuserMapper.addAtuser(userBookRecordAtusers);
        }
        return ServerResponse.createBySuccess("发布成功");
    }

    /**
     * 根据ids获取推荐图书列表
     * @param ids
     * @return
     */
    public ServerResponse getRecommendBooksByIds(String ids){
        if (ids == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        String [] arr = ids.split(",");
        List<String> stringList = new ArrayList<>();
        for (int i=0; i<arr.length;i++){
            stringList.add(arr[i]);
        }

        List<UserBookRecord> userBookRecords = userBookRecordMapper.getRecommendBooksByIds(stringList);

        if (CollectionUtils.isNotEmpty(userBookRecords)){
            return ServerResponse.createBySuccess("查询成功",userBookRecords);
        }
        return ServerResponse.createByErrorMessage("用户未推荐图书");
    }
    /**
     * 根据ids获取书拍列表
     * @param ids
     * @return
     */
    public ServerResponse getBookPhotosByIds(String ids){
        if (ids == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        String [] arr = ids.split(",");
        List<String> stringList = new ArrayList<>();
        for (int i=0; i<arr.length;i++){
            stringList.add(arr[i]);
        }
        List<UserBookRecord> userBookRecords = userBookRecordMapper.getBookPhotosByIds(stringList);
        if (CollectionUtils.isNotEmpty(userBookRecords)){
            return ServerResponse.createBySuccess("查询成功",userBookRecords);
        }
        return ServerResponse.createByErrorMessage("用户未发布书拍");
    }
    //endregion

    /**
     * 获取被@的列表
     * @param touid
     * @return
     */
    public ServerResponse getAtusers(Long touid,int pageNum,int pageSize){
        if (touid == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<UserBookRecordAtuser> userBookRecordAtusers = userBookRecordAtuserMapper.getAtusersByTouid(touid);
        if (CollectionUtils.isNotEmpty(userBookRecordAtusers)){
            List<UserBookRecordAtuserVO> userBookRecordAtuserVOS = new ArrayList<>();
            for (UserBookRecordAtuser userBookRecordAtuser : userBookRecordAtusers){
                UserBookRecordAtuserVO userBookRecordAtuserVO = new UserBookRecordAtuserVO();
                userBookRecordAtuserVO.setAtid(userBookRecordAtuser.getAtid());
                userBookRecordAtuserVO.setCreatetime(userBookRecordAtuser.getCreatetime());
                userBookRecordAtuserVO.setFromuid(userBookRecordAtuser.getFromuid());
                userBookRecordAtuserVO.setRecordid(userBookRecordAtuser.getRecordid());
                userBookRecordAtuserVO.setStatus(userBookRecordAtuser.getStatus());
                userBookRecordAtuserVO.setTouid(userBookRecordAtuser.getTouid());
                UserBookRecord userBookRecord = userBookRecordMapper.selectByPrimaryKey(userBookRecordAtuser.getRecordid());
                userBookRecordAtuserVO.setUserBookRecord(userBookRecord);
                userBookRecordAtuserVOS.add(userBookRecordAtuserVO);
            }
            PageInfo pageInfo = new PageInfo(userBookRecordAtuserVOS);
            return ServerResponse.createBySuccess("查询成功",pageInfo);
        }
        return ServerResponse.createByErrorMessage("没有被提醒的书拍");
    }
    //测试
    public ServerResponse ceshi(){
        ContentBase contentBase = new ContentBase();
        contentBase.setContentBaseid(Long.valueOf(555555));
        contentBase.setCollectioncount(0);//收藏数量
        contentBase.setLikecount(0);//点赞数量
        contentBase.setPhototype(Const.PhotoType.BookPhoto.getCode());//状态为书拍
        contentBase.setRewcount(0);
        contentBase.setSharecount(0);//分享数量
        int roucount = contentBaseMapper.insert(contentBase);
        return ServerResponse.createBySuccess("插入成功",roucount);
    }
}
