package org.advent.day1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class TestCalibratorShould {

    private Calibrator calibrator = new Calibrator();

    @Test
    void cali_value_12(){
        int result = calibrator.getCaliValue("1abc2");
        int expected = 12;
        assertThat(result, equalTo(expected));
    }

    @Test
    void cali_value_38(){
        int result = calibrator.getCaliValue("pqr3stu8vwx");
        int expected = 38;
        assertThat(result, equalTo(expected));
    }

    @Test
    void cali_value_15(){
        int result = calibrator.getCaliValue("a1b2c3d4e5f");
        int expected = 15;
        assertThat(result, equalTo(expected));
    }
    
    @Test
    void cali_value_77(){
        int result = calibrator.getCaliValue("treb7uchet");
        int expected = 77;
        assertThat(result, equalTo(expected));
    }

    @Test
    void cali_value_if_no_num_0(){
        int result = calibrator.getCaliValue("ffabc");
        int expected = 0;
        assertThat(result, equalTo(expected));
    }

    @Test
    void cali_value_29_spelling(){
        int result = calibrator.getCaliValue("two1nine");
        int expected = 29;
        assertThat(result, equalTo(expected));
    }

    @Test
    void cali_value_83_spelling(){
        int result = calibrator.getCaliValue("eightwothree");
        int expected = 83;
        assertThat(result, equalTo(expected));
    }

    @Test
    void cali_value_13_spelling(){
        int result = calibrator.getCaliValue("abcone2threexyz");
        int expected = 13;
        assertThat(result, equalTo(expected));
    }

    @Test
    void cali_value_24_spelling(){
        int result = calibrator.getCaliValue("xtwone3four");
        int expected = 24;
        assertThat(result, equalTo(expected));
    }
    
    @Test
    void cali_value_42_spelling(){
        int result = calibrator.getCaliValue("4nineeightseven2");
        int expected = 42;
        assertThat(result, equalTo(expected));
    }
    @Test
    void cali_value_14_spelling(){
        int result = calibrator.getCaliValue("zoneight234");
        int expected = 14;
        assertThat(result, equalTo(expected));
    }
    @Test
    void cali_value_76_spelling(){
        int result = calibrator.getCaliValue("7pqrstsixteen");
        int expected = 76;
        assertThat(result, equalTo(expected));
    }

}
