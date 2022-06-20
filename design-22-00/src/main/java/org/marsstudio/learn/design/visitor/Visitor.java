package org.marsstudio.learn.design.visitor;

import org.marsstudio.learn.design.user.impl.Student;
import org.marsstudio.learn.design.user.impl.Teacher;

public interface Visitor {

    void visit(Student student);

    void visit(Teacher teacher);
}
