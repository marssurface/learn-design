package org.marsstudio.learn.design.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.marsstudio.learn.design.MQAdapter;
import org.marsstudio.learn.design.OrderAdapterService;
import org.marsstudio.learn.design.RebateInfo;
import org.marsstudio.learn.design.impl.InsideOrderServiceImpl;
import org.marsstudio.learn.design.impl.POPOrderAdapterServiceImpl;
import org.marsstudio.learn.design.mq.CreateAccount;
import org.marsstudio.learn.design.mq.OrderMq;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ApiTest {

    @Test
    public void test_MQAdapter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ParseException {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = s.parse("2022-06-13 23:10:32");

        CreateAccount createAccount = new CreateAccount();

        createAccount.setNumber("100001");
        createAccount.setAddress("河北省.廊坊市.广阳区.大学里职业技术学院");
        createAccount.setAccountDate(parse);
        createAccount.setDesc("在校开户");

        HashMap<String, String> link01 = new HashMap<String, String>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");
        RebateInfo rebateInfo01 = MQAdapter.filter(createAccount.toString(), link01);

        System.out.println("mq.create_account(适配前)" + createAccount.toString());
        System.out.println("mq.create_account(适配后)" + JSON.toJSONString(rebateInfo01));


        OrderMq orderMq = new OrderMq();

        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderTime(parse);

        HashMap<String, String> link02 = new HashMap<String, String>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");

        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(), link02);

        System.out.println("mq.orderMq(适配前)" + orderMq.toString());
        System.out.println("mq.orderMq(适配后)" + JSON.toJSONString(rebateInfo02));
    }

    @Test
    public void test_itfAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();

        System.out.println("判断⾸单，接⼝适配(POP)：" + popOrderAdapterService.isFirst("100001"));

        OrderAdapterService insideOrderService = new InsideOrderServiceImpl();
        System.out.println("判断⾸单，接⼝适配(⾃营)：" + insideOrderService.isFirst("100001"));
    }

}
