package org.marsstudio.learn.design;


public class AuthInfo {

    private String code;

    private String info = "";

    public AuthInfo(String code, String ...infos) {
        this.code = code;
        this.info = info;

        for (String str: infos) {
            this.info = this.info.concat(str);
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
