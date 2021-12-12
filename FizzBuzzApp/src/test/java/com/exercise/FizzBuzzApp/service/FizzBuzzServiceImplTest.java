package com.exercise.FizzBuzzApp.service;

import com.exercise.FizzBuzzApp.model.FizzBuzzModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzServiceImplTest {

    FizzBuzzService fizzBuzzService;

    @BeforeEach
    void setup(){
        fizzBuzzService = new FizzBuzzServiceImpl();
    }

    @Test
    void should_ReturnInvalid_When_Empty() {

        String num = "";


        FizzBuzzModel fizzBuzzModel = fizzBuzzService.getFizzBuzzByNumber(num);
        String expected = "Invalid Item";

        assertEquals(expected, fizzBuzzModel.getResult().get(0));
    }

    @Test
    void should_ReturnInvalid_When_NotANumber() {

        String num = "ABC";


        FizzBuzzModel fizzBuzzModel = fizzBuzzService.getFizzBuzzByNumber(num);
        String expected = "Invalid Item";

        assertEquals(expected, fizzBuzzModel.getResult().get(0));
    }

    @Test
    void should_ReturnFizz_When_DivisibleBy3() {

        String num = "9";


        FizzBuzzModel fizzBuzzModel = fizzBuzzService.getFizzBuzzByNumber(num);
        String expected = "Fizz";

        assertEquals(expected, fizzBuzzModel.getResult().get(0));
    }
    @Test
    void should_ReturnBuzz_When_DivisibleBy5() {
        String num = "25";


        FizzBuzzModel fizzBuzzModel = fizzBuzzService.getFizzBuzzByNumber(num);
        String expected = "Buzz";

        assertEquals(expected, fizzBuzzModel.getResult().get(0));
    }
    @Test
    void should_ReturnFizzBuzz_When_DivisibleBy3And5() {

        String num = "30";


        FizzBuzzModel fizzBuzzModel = fizzBuzzService.getFizzBuzzByNumber(num);
        String expected = "FizzBuzz";

        assertEquals(expected, fizzBuzzModel.getResult().get(0));
    }
}