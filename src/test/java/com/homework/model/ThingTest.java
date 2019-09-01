package com.homework.model;

import org.junit.Assert;
import org.junit.Test;

public class ThingTest {

    private double delta = 0.00001;

    @Test
    public void getPossibilityOfHappening() {
        //given
        float possibilityOfHappening = 0.3f;
        Thing thing = new Thing(possibilityOfHappening);
        float expected = possibilityOfHappening;
        //when
        float actual = thing.getPossibilityOfHappening();
        //then
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void getPossibilityOfNotHappening() {
        //given
        float possibilityOfHappening = 0.3f;
        Thing thing = new Thing(possibilityOfHappening);
        float expected = 1 - possibilityOfHappening;
        //when
        float actual = thing.getPossibilityOfNotHappening();
        //then
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void should_get_correct_possibility_of_and() {
        //given
        Thing coinUpSide = new Thing(0.5f);
        float expected = 0.25f;
        //when
        Thing coinUpSideTwice = coinUpSide.and(coinUpSide.getPossibilityOfHappening());
        //then
        Assert.assertEquals(expected, coinUpSideTwice.getPossibilityOfHappening(), delta);
    }

    @Test
    public void should_get_correct_possibility_of_or() {
        //given
        Thing coinUpSide = new Thing(0.5f);
        Thing coinDownSide = new Thing(0.5f);
        float expected = 0.5f;
        //when
        Thing coinUpSideOrDownSideOfTwiceThrow = coinUpSide.or(coinDownSide.getPossibilityOfHappening());
        //then
        Assert.assertEquals(expected, coinUpSideOrDownSideOfTwiceThrow.getPossibilityOfHappening(), delta);
    }
}