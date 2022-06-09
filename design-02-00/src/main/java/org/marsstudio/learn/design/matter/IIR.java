package org.marsstudio.learn.design.matter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class IIR {

    private Logger logger = LoggerFactory.getLogger(IIR.class);

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        logger.info("IIR获取数据 key：{}", key);
        return dataMap.get(key);
    }

    public String set(String key, String value) {
        logger.info("IIR写入数据 key：{} val：{}", key, value);
        return dataMap.put(key, value);
    }

    public String set(String key, String value, long timeout, TimeUnit timeUnit) {
        logger.info("IIR写入数据 key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        return dataMap.put(key, value);
    }

    public String del(String key) {
        logger.info("IIR删除数据 key：{}", key);
        return dataMap.remove(key);
    }
}
