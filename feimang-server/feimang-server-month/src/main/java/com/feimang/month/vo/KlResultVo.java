package com.feimang.month.vo;

import com.feimang.month.pojo.UserAbstruct;
import com.feimang.month.pojo.UserKl;
import com.feimang.month.pojo.UserTag;

import java.util.List;

public class KlResultVo {

    private UserAbstruct userAbstruct;

    private UserKl userKl;

    private List<UserTag> userTags;

    public UserAbstruct getUserAbstruct() {
        return userAbstruct;
    }

    public void setUserAbstruct(UserAbstruct userAbstruct) {
        this.userAbstruct = userAbstruct;
    }

    public UserKl getUserKl() {
        return userKl;
    }

    public void setUserKl(UserKl userKl) {
        this.userKl = userKl;
    }

    public List<UserTag> getUserTags() {
        return userTags;
    }

    public void setUserTags(List<UserTag> userTags) {
        this.userTags = userTags;
    }
}
