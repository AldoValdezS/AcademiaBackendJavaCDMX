package com.aldo.javatest.reto2;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzShould {
    @Test
    public void if_number_is_divisible_by_3_return_fizz() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        assertThat(fizzbuzz.fizzBuzz(3), is("Fizz"));
    }
    @Test
    public void if_number_is_divisible_by_5_return_buzz() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        assertThat(fizzbuzz.fizzBuzz(10), is("Buzz"));
    }
    @Test
    public void if_number_is_divisible_by_3_and_5_return_fizzbuzz() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        assertThat(fizzbuzz.fizzBuzz(30), is("FizzBuzz"));
    }
    @Test
    public void if_number_is_not_divisible_by_3_or_5_return_same_number() {
        FizzBuzz fizzbuzz = new FizzBuzz();
        assertThat(fizzbuzz.fizzBuzz(31), is("31"));
    }


}