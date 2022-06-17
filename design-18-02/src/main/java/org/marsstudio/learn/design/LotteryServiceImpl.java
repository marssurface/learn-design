package org.marsstudio.learn.design;

import java.util.Date;

public class LotteryServiceImpl extends LotteryService {


    private MiniBusTargetService miniBusTargetService = new MiniBusTargetService();

    @Override
    protected LotteryResult doDraw(String uId) {
        // 摇号
        String lottery = miniBusTargetService.lottery(uId);

        return new LotteryResult(uId, lottery, new Date());
    }
}
