package com.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CatTest extends TestCase {

    private List<String> listOfFood;
    Cat cat;
    @Mock
    Feline feline;

    @Before
    public void setup() {
        cat = new Cat(feline);
        listOfFood = List.of("Животные", "Птицы", "Рыба");
    }

    @Test
    public void getSound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(listOfFood);
        List<String> foodCat = cat.getFood();
        assertEquals(listOfFood, foodCat);
    }
}