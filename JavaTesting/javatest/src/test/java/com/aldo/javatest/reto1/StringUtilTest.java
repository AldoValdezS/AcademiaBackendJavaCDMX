package com.aldo.javatest.reto1;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void string_is_not_void() {
       assertFalse(StringUtil.isEmpty("Hola") );
    }

    @Test
    public void string_is_void_comillas() {
        assertTrue(StringUtil.isEmpty("") );
    }
    @Test
    public void string_is_void_with_null() {
        assertTrue(StringUtil.isEmpty(null) );
    }
    @Test
    public void string_is_void_with_space() {
        assertTrue(StringUtil.isEmpty("  ") );
    }
}