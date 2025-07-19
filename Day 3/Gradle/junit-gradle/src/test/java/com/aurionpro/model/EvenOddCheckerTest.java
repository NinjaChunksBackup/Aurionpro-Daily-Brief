package com.aurionpro.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EvenOddCheckerTest 
{

    @Test
    void testEven() 
    {
        EvenOddChecker checker = new EvenOddChecker();
        assertEquals("Even", checker.check(4));
    }

    @Test
    void testOdd() 
    {
        EvenOddChecker checker = new EvenOddChecker();
        assertEquals("Odd", checker.check(7));
    }
}
