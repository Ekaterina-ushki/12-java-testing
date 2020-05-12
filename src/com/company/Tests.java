package com.company;

import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {

    @Test(expected = NumberFormatException.class)
    public void test_words_in_string(){
        Integer.decode("something");
    }

    @Test(expected = NumberFormatException.class)
    public void test_empty_string(){
        Integer.decode("");
    }

    @Test(expected = NullPointerException.class)
    public void test_null(){
        Integer.decode(null);
    }

    @Test(expected = NumberFormatException.class)
    public void test_sign_inside_number(){
        Integer.decode("20-20");
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_inside_number(){
        Integer.decode("20 20");
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_after_negative_sign(){
        Integer.decode("- 20");
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_after_positive_sign(){
        Integer.decode("+ 20");
    }

    @Test(expected = NumberFormatException.class)
    public void test_value_of_double_1(){
        Integer.decode("-20.7");
    }

    @Test(expected = NumberFormatException.class)
    public void test_value_of_double_2(){
        Integer.decode("20,7");
    }

    @Test
    public void test_negative_number(){
        assertEquals(-20, (int)Integer.decode("-20"));
    }

    @Test
    public void test_positive_number_1(){
        assertEquals(20, (int)Integer.decode("+20"));
    }

    @Test
    public void test_positive_number_2(){
        assertEquals(20, (int)Integer.decode("20"));
    }

    @Test
    public void test_hexadecimal_1(){
        assertEquals(-255, (int)Integer.decode("-0xFF"));
    }

    @Test
    public void test_hexadecimal_2(){
        assertEquals(11, (int)Integer.decode("0Xb"));
    }

   @Test
    public void test_hexadecimal_3(){
        assertEquals(177, (int)Integer.decode("#b1"));
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_inside_hexadecimal_1(){
        Integer.decode("-0x FF");
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_inside_hexadecimal_2(){
        Integer.decode("0X b");
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_inside_hexadecimal_3(){
        Integer.decode("# b");
    }

    @Test
    public void test_octal_positive(){
        assertEquals(63, (int)Integer.decode("077"));
    }

    @Test
    public void test_octal_negative(){
        assertEquals(-63, (int)Integer.decode("-077"));
    }

    @Test(expected = NumberFormatException.class)
    public void test_space_inside_octal(){
        Integer.decode("0 77");
    }
}
