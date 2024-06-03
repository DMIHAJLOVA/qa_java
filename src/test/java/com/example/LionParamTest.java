package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParamTest {

    boolean expectedResult;
    String sex;

    @Parameterized.Parameters
    public static Object [][] data(){
        return new Object[][]{
                {"Самец",true},
                {"Самка",false}
        };
    }
    public LionParamTest(String sex, boolean expectedResult) {
        this.sex = sex;
        this.expectedResult=expectedResult;
    }

    @Test
    public void doesHaveMane() throws Exception {

       Lion lion = new Lion(sex, null);
        Assert.assertEquals(expectedResult, lion.doesHaveMane());
    }
}