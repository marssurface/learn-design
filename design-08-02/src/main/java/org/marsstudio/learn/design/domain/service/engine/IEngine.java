package org.marsstudio.learn.design.domain.service.engine;

import org.marsstudio.learn.design.domain.model.aggregates.TreeRich;
import org.marsstudio.learn.design.domain.model.vo.EngineResult;

import java.util.Map;

/**
 * 决策树引擎接口
 */
public interface IEngine {

    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);
}
