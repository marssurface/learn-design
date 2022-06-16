package org.marsstudio.learn.design.impl;

import org.marsstudio.learn.design.AuthInfo;
import org.marsstudio.learn.design.AuthLink;
import org.marsstudio.learn.design.AuthService;

import java.util.Date;

public class Level1AuthLink extends AuthLink {


    public Level1AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);

        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待⼀级审批负责⼈ ", levelUserName);
        }

        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：⼀级审批完成负责⼈", " 时间：", f.format(date), " 审批⼈：", levelUserName);
        }
        return next.doAuth(uId, orderId, authDate);
    }
}
