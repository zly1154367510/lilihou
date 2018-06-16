package com.zly.model;

import java.util.List;

public class SeckiilItem {
    private Long id;

    private Long sId;

    private Long iId;

    private String newPrice;

    private Long num;

    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public SeckiilItem(Long id, Long sId, Long iId, String newPrice, Long num) {
        this.id = id;
        this.sId = sId;
        this.iId = iId;
        this.newPrice = newPrice;
        this.num = num;
    }

    public SeckiilItem() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public Long getiId() {
        return iId;
    }

    public void setiId(Long iId) {
        this.iId = iId;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice == null ? null : newPrice.trim();
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}