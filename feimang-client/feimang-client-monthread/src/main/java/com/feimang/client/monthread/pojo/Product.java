package com.feimang.client.monthread.pojo;

public class Product {
    private Long id;

    private String name;

    private Integer count;

    private Double price;

    private Integer sort;

    private Integer expiry;

    private String addtime;

    public Product(Long id, String name, Integer count, Double price, Integer sort, Integer expiry, String addtime) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.sort = sort;
        this.expiry = expiry;
        this.addtime = addtime;
    }

    public Product() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getExpiry() {
        return expiry;
    }

    public void setExpiry(Integer expiry) {
        this.expiry = expiry;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}