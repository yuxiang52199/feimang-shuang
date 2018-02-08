package com.feimang.userstudy.vo;

import com.feimang.userstudy.pojo.BooktagRelation;

import java.util.List;

/**
 * Created by yxm on 2018/2/3
 */
public class BookTagRelations {

    public List<BooktagRelation> booktagRelations;

    public Integer fromUtid; //从这个书架移动

    public Integer toUtid; // 目标书架

    public List<BooktagRelation> getBooktagRelations() {
        return booktagRelations;
    }

    public void setBooktagRelations(List<BooktagRelation> booktagRelations) {
        this.booktagRelations = booktagRelations;
    }

    public Integer getFromUtid() {
        return fromUtid;
    }

    public void setFromUtid(Integer fromUtid) {
        this.fromUtid = fromUtid;
    }

    public Integer getToUtid() {
        return toUtid;
    }

    public void setToUtid(Integer toUtid) {
        this.toUtid = toUtid;
    }
}
