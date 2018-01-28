package com.feimang.userstudy.pojo;

import java.util.Date;

public class UserBookPerfectWithBLOBs extends UserBookPerfect {
    private String authorintro;

    private String catalog;

    private String summary;

    public UserBookPerfectWithBLOBs(Long perfectid, Long bookid, Long fromuid, String bookname, String isbn, String author, String price, String publisher, String pubdate, Date createtime, Date lastupdatetime, Integer imgflg, Integer perfectstatus, String cover, String authorintro, String catalog, String summary) {
        super(perfectid, bookid, fromuid, bookname, isbn, author, price, publisher, pubdate, createtime, lastupdatetime, imgflg, perfectstatus, cover);
        this.authorintro = authorintro;
        this.catalog = catalog;
        this.summary = summary;
    }

    public UserBookPerfectWithBLOBs() {
        super();
    }

    public String getAuthorintro() {
        return authorintro;
    }

    public void setAuthorintro(String authorintro) {
        this.authorintro = authorintro == null ? null : authorintro.trim();
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog == null ? null : catalog.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }
}