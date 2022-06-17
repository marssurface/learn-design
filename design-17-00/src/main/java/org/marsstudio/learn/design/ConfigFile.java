package org.marsstudio.learn.design;

import java.util.Date;

public class ConfigFile {
    private String versionNo;

    private String content;

    private Date dateTime;

    private String operator;

    public ConfigFile(String versionNo, String content, Date dateTime, String operator) {
        this.versionNo = versionNo;
        this.content = content;
        this.dateTime = dateTime;
        this.operator = operator;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
