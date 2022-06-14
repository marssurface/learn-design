package org.marsstudio.learn.design.domain.service.engine;

import org.marsstudio.learn.design.domain.service.logic.LogicFilter;
import org.marsstudio.learn.design.domain.service.logic.impl.UserAgeFilter;
import org.marsstudio.learn.design.domain.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 决策节点配置
 */
public class EngineConfig {

    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public static Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public static void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        EngineConfig.logicFilterMap = logicFilterMap;
    }
}
