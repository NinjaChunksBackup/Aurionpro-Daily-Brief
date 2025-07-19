package com.aurionpro.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilTest 
{

    MathUtil obj;

    @BeforeEach
    void init() 
    {
        obj = new MathUtil();
        System.out.println("Before Each");
    }

    @BeforeAll
    void beforeAll() 
    {
        System.out.println("Before All");
    }

    @AfterEach
    void afterEach() 
    {
        System.out.println("After Each");
    }

    @Test
    void testAddition() 
    {
        assertTrue(obj.addition(10, 20) == 30);
    }

    @Test
    void testDivision() 
    {
        assertEquals(2, obj.division(10, 5));
    }

    @Test
    void testDivision_ArithmeticException() 
    {
        assertThrows(ArithmeticException.class, () -> obj.division(5, 0));
    }

    @Test
    void testSortArray() 
    {
        int[] arr = {10, 40, 30, 2, 1};
        int[] expected = {1, 2, 10, 30, 40};
        assertArrayEquals(expected, obj.sortArray(arr));
    }
}
