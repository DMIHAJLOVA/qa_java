package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    List<String> listOfFood;
    Lion lion;
    String sex = "Самец";
    int count;
    @Mock
    Feline feline;

    @Before
    public void setup() throws Exception {
        lion = new Lion(sex,feline);
        listOfFood = List.of("Животные", "Птицы", "Рыба");
        count = 1;
    }

    @Test
    public void getKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int result = lion.getKittens();
        assertEquals(count, result);
    }

    @Test
    public void foodLionTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(listOfFood);
        List<String> result = lion.getFood();
        assertEquals(listOfFood, result);
    }
}
