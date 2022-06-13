package org.marsstudio.learn.design;

import java.util.Date;

public class RebateInfo {

    private String userId; // 用户id
    private String bizId; // 业务id
    private Date bizTime; // 业务时间
    private String desc; // 业务描述

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Date getBizTime() {
        return bizTime;
    }

    public void setBizTime(Date bizTime) {
        this.bizTime = bizTime;
    }

    public void setBizTime(String bizTime) {
        this.bizTime = new Date(Long.parseLong(bizTime));
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
