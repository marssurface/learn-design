package org.marsstudio.learn.design.store;

import org.marsstudio.learn.design.store.impl.CardCommodityService;
import org.marsstudio.learn.design.store.impl.CouponCommodityService;
import org.marsstudio.learn.design.store.impl.GoodsCommodityService;

public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) {
            return null;
        } else if (1 == commodityType) {
            return new CouponCommodityService();
        } else if (2 == commodityType) {
            return new GoodsCommodityService();
        } else if (3 == commodityType) {
            return new CardCommodityService();
        }
        throw new RuntimeException("不存在的商品服务类型");
    }
}
