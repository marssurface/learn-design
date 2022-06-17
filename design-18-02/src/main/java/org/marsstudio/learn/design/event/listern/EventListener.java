package org.marsstudio.learn.design.event.listern;

import org.marsstudio.learn.design.LotteryResult;

public interface EventListener {
    void doEvent(LotteryResult result);
}
