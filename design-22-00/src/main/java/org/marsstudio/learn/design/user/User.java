package org.marsstudio.learn.design.user;

import org.marsstudio.learn.design.visitor.Visitor;

public abstract class User {
    public String name;

    public String identity;

    public String clazz;

    public User(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }

    public abstract void accept(Visitor visitor);
}
