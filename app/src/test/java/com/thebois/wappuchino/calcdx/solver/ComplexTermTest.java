package com.thebois.wappuchino.calcdx.solver;

import org.junit.Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by wappuchino on 12/22/17.
 */
public class ComplexTermTest {
    @Test
    public void testEmptyConstructor() throws Exception
    {
        assertEquals("0", new ComplexTerm().toString());
    }

    @Test
    public void testBigintConstructor1() throws Exception
    {
        assertEquals("1+i", new ComplexTerm(BigInteger.ONE, BigInteger.ONE).toString());
    }

    @Test
    public void testBigintConstructor2() throws Exception
    {
        assertEquals("1+10i", new ComplexTerm(BigInteger.ONE, BigInteger.TEN).toString());
    }

    @Test
    public void testBigDecimalConstructor1() throws Exception
    {
        assertEquals("2.4+i", new ComplexTerm(new BigDecimal("2.4"), BigDecimal.ONE).toString());
    }

    @Test
    public void testDoubleConstructor() throws Exception
    {
        assertEquals("3.5i", new ComplexTerm(0, 3.5).toString());
    }

}