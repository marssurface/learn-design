package org.marsstudio.learn.design.cook.impl;

import org.marsstudio.learn.design.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShangDongCook implements ICook {

    private Logger logger = LoggerFactory.getLogger(ICook.class);

    @Override
    public void doCooking() {
        logger.info("山东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味为龙头");
    }
}
