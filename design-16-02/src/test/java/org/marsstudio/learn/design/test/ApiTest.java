package org.marsstudio.learn.design.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.marsstudio.learn.design.mediator.Resources;
import org.marsstudio.learn.design.mediator.SqlSession;
import org.marsstudio.learn.design.mediator.SqlSessionFactory;
import org.marsstudio.learn.design.mediator.SqlSessionFactoryBuilder;
import org.marsstudio.learn.design.po.School;
import org.marsstudio.learn.design.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;
import java.util.List;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_queryUserInfoById() {
        String resource = "mybatis-config-dataSource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory  sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();

            try {
                User user = session.selectOne("org.marsstudio.learn.design.dao.IUserDao.queryUserInfoById", 1L);
                logger.info("测试结果：{}", JSON.toJSONString(user));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_queryUserList() {
        String resource = "mybatis-config-dataSource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory  sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();

            try {
                List<User> users = session.selectList("org.marsstudio.learn.design.dao.IUserDao.queryUserList");
                logger.info("测试结果：{}", JSON.toJSONString(users));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test_querySchoolInfoById() {
        String resource = "mybatis-config-dataSource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory  sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();

            try {
                School school = session.selectOne("org.marsstudio.learn.design.dao.ISchoolDao.querySchoolInfoById", 1L);
                logger.info("测试结果：{}", JSON.toJSONString(school));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
