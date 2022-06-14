package org.marsstudio.learn.design.domain.service.logic.impl;

import org.marsstudio.learn.design.domain.service.logic.BaseLogic;

import java.util.Map;

/**
 * 性别过滤器
 */
public class UserGenderFilter extends BaseLogic {
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }
}
