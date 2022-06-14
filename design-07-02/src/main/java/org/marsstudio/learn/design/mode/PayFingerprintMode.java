package org.marsstudio.learn.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayFingerprintMode implements IPayMode {

    private Logger logger = LoggerFactory.getLogger(PayFingerprintMode.class);

    @Override
    public boolean security(String uId) {
        logger.info("指纹支付，风控校验指纹信息");
        return true;
    }
}
