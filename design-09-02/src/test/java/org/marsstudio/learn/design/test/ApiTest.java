package org.marsstudio.learn.design.test;

import org.junit.Test;
import org.marsstudio.learn.design.LoginSsoDecorator;
import org.marsstudio.learn.design.SsoInterception;

public class ApiTest {

    @Test
    public void test_LoginSsoDecorator() {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterception());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "test装饰", "t");
        System.out.println("登录校验：" + request + (success ? " 放⾏" : " 拦 截"));
    }
}
