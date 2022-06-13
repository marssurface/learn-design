package org.marsstudio.learn.design.test;

import org.junit.Test;
import org.marsstudio.learn.design.QuestionBankController;

public class ApiTest {

    @Test
    public  void test_QuestionBank() throws CloneNotSupportedException {
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper("花花", "1000001921032"));
        System.out.println(questionBankController.createPaper("小李", "1000001921899"));
        System.out.println(questionBankController.createPaper("小王", "1000001950000"));
    }
}
