package org.marsstudio.learn.design.impl;

import org.marsstudio.learn.design.OrderAdapterService;
import org.marsstudio.learn.design.service.OrderService;
import org.marsstudio.learn.design.service.POPOrderService;

public class POPOrderAdapterServiceImpl implements OrderAdapterService {


    private POPOrderService popOrderService = new POPOrderService();


    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }
}
