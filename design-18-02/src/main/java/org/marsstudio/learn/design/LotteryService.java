package org.marsstudio.learn.design;

import org.marsstudio.learn.design.event.EventManager;
import org.marsstudio.learn.design.event.listern.MQEventListener;
import org.marsstudio.learn.design.event.listern.MessageEventListener;

public abstract class LotteryService {

    private EventManager eventManager;

    public LotteryService() {
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }


    public LotteryResult draw(String uId) {
        LotteryResult lotteryResult = doDraw(uId);
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);
        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uId);
}
