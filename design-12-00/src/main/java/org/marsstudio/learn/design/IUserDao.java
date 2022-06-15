package org.marsstudio.learn.design;

import org.marsstudio.learn.design.agent.Select;

/**
 * dao 层
 */
public interface IUserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);
}
