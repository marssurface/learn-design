package org.marsstudio.learn.design.dao;

import org.marsstudio.learn.design.po.User;

import java.util.List;

public interface IUserDao {

    User queryUserInfoById(Long id);

    List<User> queryUserList();
}
