package org.marsstudio.learn.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {

    private static Logger logger = LoggerFactory.getLogger(JDBCUtil.class);

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/learn_design";

    public static final String USER = "root";

    public static final String PASSWORD = "123456";

    public static void main(String[] args) throws Exception {
        // 加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        // 获取数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        // 操作数据库
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT id, name, age, createTime, updateTime FROM user");

        while (resultSet.next()) {
            logger.info("测试结果 姓名：{} 年龄：{}", resultSet.getString("name"), resultSet.getInt("age"));
        }

    }
}
