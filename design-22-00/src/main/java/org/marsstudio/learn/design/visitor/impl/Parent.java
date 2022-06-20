package org.marsstudio.learn.design.visitor.impl;

import org.marsstudio.learn.design.user.impl.Student;
import org.marsstudio.learn.design.user.impl.Teacher;
import org.marsstudio.learn.design.visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parent implements Visitor {

    private Logger logger = LoggerFactory.getLogger(Principal.class);


    @Override
    public void visit(Student student) {
        logger.info("学生信息 姓名：{} 班级：{} 排名：{}", student.name, student.clazz, student.ranking());
    }

    @Override
    public void visit(Teacher teacher) {
        logger.info("老师信息 姓名：{} 班级：{} 级别：{}", teacher.name, teacher.clazz, teacher.identity);
    }
}
