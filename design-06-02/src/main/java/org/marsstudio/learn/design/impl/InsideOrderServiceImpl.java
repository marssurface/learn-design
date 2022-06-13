package org.marsstudio.learn.design.impl;

import org.marsstudio.learn.design.OrderAdapterService;
import org.marsstudio.learn.design.service.OrderService;

public class InsideOrderServiceImpl implements OrderAdapterService {


    private OrderService orderService = new OrderService();

    @Override
    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }
}
