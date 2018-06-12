package com.zly.model;

import java.util.Date;

/**
 * Created by zly11 on 2018/6/11.
 */
public class Message {

    private String content;

    private String createDate;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
