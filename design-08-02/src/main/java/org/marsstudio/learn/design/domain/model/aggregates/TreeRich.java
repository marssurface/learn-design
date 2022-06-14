package org.marsstudio.learn.design.domain.model.aggregates;

import org.marsstudio.learn.design.domain.model.vo.TreeNode;
import org.marsstudio.learn.design.domain.model.vo.TreeRoot;

import java.util.Map;

/**
 * 规则树聚合
 */
public class TreeRich {

    private TreeRoot treeRoot;          //树根信息

    private Map<Long, TreeNode> treeNodeMap; //树节点id -> 子节点ID

    public TreeRich(TreeRoot treeRoot, Map<Long, TreeNode> treeNodeMap) {
        this.treeRoot = treeRoot;
        this.treeNodeMap = treeNodeMap;
    }

    public TreeRoot getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRoot treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNode> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNode> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }
}
