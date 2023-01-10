package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionParametersExceptionTest {

    @Mock
    Feline feline;

    private final String sex;
    private final String expected;

    public LionParametersExceptionTest(String sex, String expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] lionHaveMane() {
        return new Object[][]{
                {"Самище", "Используйте допустимые значения пола животного - самец или самка"},
                {"1111", "Используйте допустимые значения пола животного - самец или самка"},
        };
    }

    @Test
    public void doesHaveMane() throws Exception {

        String exception = "";
        try {
            Lion lion = new Lion(sex, feline);
        } catch (Exception ex) {
            exception = ex.getMessage();
        }
        assertEquals(exception, expected);
    }

}
