package org.marsstudio.learn.design.domain.service.logic.impl;

import org.marsstudio.learn.design.domain.service.logic.BaseLogic;

import java.util.Map;

/**
 * 年龄过滤器
 */
public class UserAgeFilter extends BaseLogic {
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }
}
