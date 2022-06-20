package org.marsstudio.learn.design.test;

import org.junit.Test;
import org.marsstudio.learn.design.DataView;
import org.marsstudio.learn.design.visitor.impl.Parent;
import org.marsstudio.learn.design.visitor.impl.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test() {
        DataView dataView = new DataView();
        logger.info("\r\n家长视角访问：");
        dataView.show(new Parent());

        logger.info("\r\n校长视角访问：");
        dataView.show(new Principal());
    }

}
