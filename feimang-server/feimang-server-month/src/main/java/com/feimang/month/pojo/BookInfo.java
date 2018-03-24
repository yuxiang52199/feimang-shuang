package com.feimang.month.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class BookInfo {
    private Long bookid;

    private String isbn;

    private String bookname;

    private String author;

    private String price;

    private BigDecimal priceD;

    private String publisher;

    private String pubdate;

    private Integer pubdatetime;

    private String authorintro;

    private String catalog;

    private String summary;

    private Integer category;

    private String cover;

    private Double average;

    private Integer imgflg;

    private Byte bookstatus;

    private Date createtime;

    public BookInfo(Long bookid, String isbn, String bookname, String author, String price, BigDecimal priceD, String publisher, String pubdate, Integer pubdatetime, String authorintro, String catalog, String summary, Integer category, String cover, Double average, Integer imgflg, Byte bookstatus, Date createtime) {
        this.bookid = bookid;
        this.isbn = isbn;
        this.bookname = bookname;
        this.author = author;
        this.price = price;
        this.priceD = priceD;
        this.publisher = publisher;
        this.pubdate = pubdate;
        this.pubdatetime = pubdatetime;
        this.authorintro = authorintro;
        this.catalog = catalog;
        this.summary = summary;
        this.category = category;
        this.cover = cover;
        this.average = average;
        this.imgflg = imgflg;
        this.bookstatus = bookstatus;
        this.createtime = createtime;
    }

    public BookInfo() {
        super();
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public BigDecimal getPriceD() {
        return priceD;
    }

    public void setPriceD(BigDecimal priceD) {
        this.priceD = priceD;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate == null ? null : pubdate.trim();
    }

    public Integer getPubdatetime() {
        return pubdatetime;
    }

    public void setPubdatetime(Integer pubdatetime) {
        this.pubdatetime = pubdatetime;
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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Integer getImgflg() {
        return imgflg;
    }

    public void setImgflg(Integer imgflg) {
        this.imgflg = imgflg;
    }

    public Byte getBookstatus() {
        return bookstatus;
    }

    public void setBookstatus(Byte bookstatus) {
        this.bookstatus = bookstatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}