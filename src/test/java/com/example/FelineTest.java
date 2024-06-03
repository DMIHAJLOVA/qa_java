package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    private List<String> listOfFood;
    private int count;
    private String family;

    @Before
    public void setup() {
        listOfFood = List.of("Животные", "Птицы", "Рыба");
        count = 1;
        family = "Кошачьи";
    }

    @Test
    public void eatMeat() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(listOfFood);
        List<String> foodList = feline.eatMeat();
        Assert.assertEquals(listOfFood, foodList);
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamily() {
        String result = feline.getFamily();
        assertEquals(family, result);
    }

    @Test
    public void getKittensWithoutParams() {
        int result = feline.getKittens();
        assertEquals(count, result);
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getMoreThenOneKitten() {
        int result = feline.getKittens(2);
        assertEquals(2, result);
    }
}
