package org.marsstudio.learn.design.user.impl;

import org.marsstudio.learn.design.user.User;
import org.marsstudio.learn.design.visitor.Visitor;

public class Student extends User {
    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int ranking() {
        return (int) (Math.random() * 100);
    }
}
