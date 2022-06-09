package org.marsstudio.learn.design.test;

import org.junit.Test;
import org.marsstudio.learn.design.CacheService;
import org.marsstudio.learn.design.factory.JDKProxy;
import org.marsstudio.learn.design.factory.impl.EGMCacheAdapterImpl;
import org.marsstudio.learn.design.factory.impl.IIRCacheAdapter;
import org.marsstudio.learn.design.impl.CacheServiceImpl;

public class ApiTest {

    @Test
    public void test_CacheService() throws Exception {
        CacheService proxyEgm = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapterImpl());
        proxyEgm.set("user_name_01", "marsstudio");
        String val01 = proxyEgm.get("user_name_01");
        System.out.println("测试结果：" + val01);

        CacheService proxyIir = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxyIir.set("user_name_02", "marsstudio");
        String val02 = proxyIir.get("user_name_02");
        System.out.println("测试结果：" + val02);

    }
}
