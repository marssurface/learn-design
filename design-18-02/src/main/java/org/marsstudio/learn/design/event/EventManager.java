package org.marsstudio.learn.design.event;

import javafx.event.Event;
import javafx.event.EventType;
import org.marsstudio.learn.design.LotteryResult;
import org.marsstudio.learn.design.event.listern.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 事件处理类
 */
public class EventManager {

    Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();

    public EventManager(Enum<EventType>... operations) {
        for (Enum<EventType> operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public enum EventType {
        MQ, Message;
    }

    /**
     * 订阅
     *
     * @param eventType 事件类型
     * @param listener  监听
     */
    public void subscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    /**
     * 取消订阅
     * @param eventType
     * @param listener
     */
    public void unSubscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    /**
     *  通知
     * @param eventType
     * @param result
     */
    public void notify(Enum<EventType> eventType, LotteryResult result) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener: users) {
            listener.doEvent(result);
        }
    }


}
