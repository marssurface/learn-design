package org.marsstudio.learn.design.event;

import org.marsstudio.learn.design.ICouponDiscount;

import java.math.BigDecimal;

public class NYCouponDiscount implements ICouponDiscount<Double> {

    /**
     * n元购购买
     * 1. 无论原价多少钱都固定金额购买
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }
}
