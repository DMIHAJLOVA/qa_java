package com.example;


import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionExceptionTest {
    private static final String EXPECTED_ERROR = "Используйте допустимые значения пола животного - самец или самка";
     private final String sex;

    @Parameterized.Parameters
    public static Object [][] data(){
        return new Object[][]{
                {"unknown"},
                {null},
                {"черепаха"}
        };
    }

    public LionExceptionTest(String sex) {

        this.sex = sex;
    }


@Test
    public void doesHaveManeNegative()  {
    Exception exception = assertThrows(Exception.class, ()-> new Lion(sex, null));
    Assert.assertEquals(EXPECTED_ERROR, exception.getMessage());
}


}
