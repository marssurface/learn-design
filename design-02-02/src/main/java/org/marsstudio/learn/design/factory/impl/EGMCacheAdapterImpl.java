package org.marsstudio.learn.design.factory.impl;

import org.marsstudio.learn.design.factory.ICacheAdapter;
import org.marsstudio.learn.design.matter.EGM;

import java.util.concurrent.TimeUnit;

public class EGMCacheAdapterImpl implements ICacheAdapter {

    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
