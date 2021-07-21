package bai9_automated_testing_tdd.bai_tap.chuong_trinh_tinh_fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {

    @Test
    void translateNumber1() {
        int number = 15;
        String expected = "FizzBuzz";
        String result = FizzBuzzTranslate.translateNumber(number);
        assertEquals(expected,result);
    }
    @Test
    void translateNumber2() {
        int number = 18;
        String expected = "Fizz";
        String result = FizzBuzzTranslate.translateNumber(number);
        assertEquals(expected,result);
    }
    @Test
    void translateNumber3() {
        int number = 50;
        String expected = "Buzz";
        String result = FizzBuzzTranslate.translateNumber(number);
        assertEquals(expected,result);
    }
    @Test
    void translateNumber4() {
        int number = 53;
        String expected = "five three";
        String result = FizzBuzzTranslate.translateNumber(number);
        assertEquals(expected,result);
    }
    @Test
    void translateNumber5() {
        int number = -10;
        String expected = "Can not translate";
        String result = FizzBuzzTranslate.translateNumber(number);
        assertEquals(expected,result);
    }
    @Test
    void translateNumber6() {
        int number = 210;
        String expected = "Can not translate";
        String result = FizzBuzzTranslate.translateNumber(number);
        assertEquals(expected,result);
    }
}