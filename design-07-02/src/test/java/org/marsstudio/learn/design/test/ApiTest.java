package org.marsstudio.learn.design.test;

import org.junit.Test;
import org.marsstudio.learn.design.channel.Pay;
import org.marsstudio.learn.design.channel.WxPay;
import org.marsstudio.learn.design.channel.ZfbPay;
import org.marsstudio.learn.design.mode.PayFaceMode;
import org.marsstudio.learn.design.mode.PayFingerprintMode;

import java.math.BigDecimal;

public class ApiTest {

    @Test
    public void test_pay() {
        System.out.println("\r\n模拟测试场景；微信⽀付、⼈脸⽅式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111","100000109894",new BigDecimal(100));

    }
}
