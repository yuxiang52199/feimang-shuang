package com.feimang.userstudy.pojo;

public class BookInfoWithBLOBs extends BookInfo {
    private String authorintro;

    private String catalog;

    private String summary;

    public BookInfoWithBLOBs(Long bookid, String isbn, String isbn10, String bookname, String nameother, String origintitle, String author, String translator, String language, String price, String publisher, String pubdate, Integer pubdatetime, String version, String page, String packaging, String format, Integer printpage, Integer words, Integer category, Integer isapproved, String cover, String idtype, Long doubanid, Date createtime, Byte bookstatus, Date lastupdatetime, Byte tagstatus, Double average, String presscode, Integer imgflg, Byte ismore, Byte iscomplete, Byte authorintroisnull, Byte catalogisnull, Byte summaryisnull, Integer catalogstatus, BigDecimal priceD, String authorintro, String catalog, String summary) {
        super(bookid, isbn, isbn10, bookname, nameother, origintitle, author, translator, language, price, publisher, pubdate, pubdatetime, version, page, packaging, format, printpage, words, category, isapproved, cover, idtype, doubanid, createtime, bookstatus, lastupdatetime, tagstatus, average, presscode, imgflg, ismore, iscomplete, authorintroisnull, catalogisnull, summaryisnull, catalogstatus, priceD);
        this.authorintro = authorintro;
        this.catalog = catalog;
        this.summary = summary;
    }

    public BookInfoWithBLOBs() {
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