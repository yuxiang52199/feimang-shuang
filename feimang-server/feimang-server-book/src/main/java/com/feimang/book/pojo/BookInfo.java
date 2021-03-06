package com.feimang.book.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class BookInfo {
    private Long bookid;

    private String isbn;

    private String isbn10;

    private String bookname;

    private String nameother;

    private String origintitle;

    private String author;

    private String translator;

    private String language;

    private String price;

    private BigDecimal priceD;

    private String publisher;

    private String pubdate;

    private Integer pubdatetime;

    private String version;

    private String page;

    private String packaging;

    private String format;

    private Integer printpage;

    private Integer words;

    private String authorintro;

    private String catalog;

    private String summary;

    private Integer category;

    private String cover;

    private Double average;

    private String presscode;

    private Integer imgflg;

    private String idtype;

    private Byte ismore;

    private Byte iscomplete;

    private Integer isapproved;

    private Byte bookstatus;

    private Date createtime;

    private Date lastupdatetime;

    public BookInfo(Long bookid, String isbn, String isbn10, String bookname, String nameother, String origintitle, String author, String translator, String language, String price, BigDecimal priceD, String publisher, String pubdate, Integer pubdatetime, String version, String page, String packaging, String format, Integer printpage, Integer words, String authorintro, String catalog, String summary, Integer category, String cover, Double average, String presscode, Integer imgflg, String idtype, Byte ismore, Byte iscomplete, Integer isapproved, Byte bookstatus, Date createtime, Date lastupdatetime) {
        this.bookid = bookid;
        this.isbn = isbn;
        this.isbn10 = isbn10;
        this.bookname = bookname;
        this.nameother = nameother;
        this.origintitle = origintitle;
        this.author = author;
        this.translator = translator;
        this.language = language;
        this.price = price;
        this.priceD = priceD;
        this.publisher = publisher;
        this.pubdate = pubdate;
        this.pubdatetime = pubdatetime;
        this.version = version;
        this.page = page;
        this.packaging = packaging;
        this.format = format;
        this.printpage = printpage;
        this.words = words;
        this.authorintro = authorintro;
        this.catalog = catalog;
        this.summary = summary;
        this.category = category;
        this.cover = cover;
        this.average = average;
        this.presscode = presscode;
        this.imgflg = imgflg;
        this.idtype = idtype;
        this.ismore = ismore;
        this.iscomplete = iscomplete;
        this.isapproved = isapproved;
        this.bookstatus = bookstatus;
        this.createtime = createtime;
        this.lastupdatetime = lastupdatetime;
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

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10 == null ? null : isbn10.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getNameother() {
        return nameother;
    }

    public void setNameother(String nameother) {
        this.nameother = nameother == null ? null : nameother.trim();
    }

    public String getOrigintitle() {
        return origintitle;
    }

    public void setOrigintitle(String origintitle) {
        this.origintitle = origintitle == null ? null : origintitle.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator == null ? null : translator.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging == null ? null : packaging.trim();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }

    public Integer getPrintpage() {
        return printpage;
    }

    public void setPrintpage(Integer printpage) {
        this.printpage = printpage;
    }

    public Integer getWords() {
        return words;
    }

    public void setWords(Integer words) {
        this.words = words;
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

    public String getPresscode() {
        return presscode;
    }

    public void setPresscode(String presscode) {
        this.presscode = presscode == null ? null : presscode.trim();
    }

    public Integer getImgflg() {
        return imgflg;
    }

    public void setImgflg(Integer imgflg) {
        this.imgflg = imgflg;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype == null ? null : idtype.trim();
    }

    public Byte getIsmore() {
        return ismore;
    }

    public void setIsmore(Byte ismore) {
        this.ismore = ismore;
    }

    public Byte getIscomplete() {
        return iscomplete;
    }

    public void setIscomplete(Byte iscomplete) {
        this.iscomplete = iscomplete;
    }

    public Integer getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(Integer isapproved) {
        this.isapproved = isapproved;
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

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }
}