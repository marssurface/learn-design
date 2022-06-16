package org.marsstudio.learn.design.cook.impl;

import org.marsstudio.learn.design.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuangDongCook implements ICook {

    private Logger logger = LoggerFactory.getLogger(ICook.class);

    @Override
    public void doCooking() {
        logger.info("⼴东厨师，烹饪鲁菜，宫廷最⼤菜系，以孔府⻛味为⻰头");
    }
}
