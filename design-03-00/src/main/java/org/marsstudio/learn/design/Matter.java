package org.marsstudio.learn.design;

import java.math.BigDecimal;

/**
 * 装修类
 */
public interface Matter {

    /**
     * 场景；地板、地砖、涂料、吊顶
     *
     * @return
     */
    String scene();

    /**
     * 品牌
     *
     * @return
     */
    String brand();

    /**
     * 型号
     *
     * @return
     */
    String model();

    /**
     * 平米报价
     *
     * @return
     */
    BigDecimal price();

    /**
     * 描述
     *
     * @return
     */
    String desc();
}
