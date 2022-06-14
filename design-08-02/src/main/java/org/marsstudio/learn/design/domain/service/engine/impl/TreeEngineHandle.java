package org.marsstudio.learn.design.domain.service.engine.impl;

import org.marsstudio.learn.design.domain.model.aggregates.TreeRich;
import org.marsstudio.learn.design.domain.model.vo.EngineResult;
import org.marsstudio.learn.design.domain.model.vo.TreeNode;
import org.marsstudio.learn.design.domain.service.engine.EngineBase;

import java.util.Map;

public class TreeEngineHandle extends EngineBase {
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }
}
