package org.marsstudio.learn.design;

import org.marsstudio.learn.design.util.RedisUtil;

public class ActivityController {

    private RedisUtil redisUtil = new RedisUtil();


    public Activity queryActivityInfo(Long id) {
        Activity activity = ActivityFactory.getActivity(id);
        // 模拟从redis中获取库存变化

        Stock stock = new Stock(100, redisUtil.getStock());

        activity.setStock(stock);
        return activity;
    }
}
