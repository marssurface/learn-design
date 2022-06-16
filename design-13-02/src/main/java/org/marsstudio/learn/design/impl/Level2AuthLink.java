package org.marsstudio.learn.design.impl;

import org.marsstudio.learn.design.AuthInfo;
import org.marsstudio.learn.design.AuthLink;
import org.marsstudio.learn.design.AuthService;

import java.text.ParseException;
import java.util.Date;

public class Level2AuthLink extends AuthLink {

    private Date beginDate = f.parse("2022-06-11 00:00:00");
    private Date endDate = f.parse("2022-06-20 23:59:59");

    public Level2AuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);

        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待二级审批负责⼈ ", levelUserName);
        }

        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：二级审批完成负责⼈", " 时间：", f.format(date), " 审批⼈：", levelUserName);
        }

        if (authDate.before(beginDate) || authDate.after(endDate)) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：二级审批完成负责⼈", " 时间：", f.format(date), " 审批⼈：", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }
}
