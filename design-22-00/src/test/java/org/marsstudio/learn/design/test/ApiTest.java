package org.marsstudio.learn.design.test;

import org.junit.Test;
import org.marsstudio.learn.design.NetMall;
import org.marsstudio.learn.design.impl.JDNetMall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_NetMall() {
        NetMall netMall = new JDNetMall("1000001","*******");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        logger.info("测试结果：{}", base64);
    }
}
