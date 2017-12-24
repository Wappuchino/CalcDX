/*
 ***************************************************************************************************
 * The IntegerTerm denotes a single numerical integer term. As it represents a numerical value,    *
 * it is considered a subtype of the value term.                                                   *
 *                                                                                                 *
 * For nearly all purposes, it is expected that this term be an operand, so it has no child        *
 * terms as expected of most value terms.                                                          *
 *                                                                                                 *
 * - Wappuchino                                                                                    *
 **************************************************************************************************/

package com.thebois.wappuchino.calcdx.solver;

import java.math.BigInteger;

/**
 * The IntegerTerm class is a class representing an integer value.
 *
 * This class follows the general contract of value terms having no children.
 */
public class IntegerTerm extends GaussianTerm {
    public IntegerTerm()
    {
        super();
    }

    public IntegerTerm(long val)
    {
        super(val, 0);
    }

    public IntegerTerm(BigInteger val)
    {
        super(val, BigInteger.ZERO);
    }

    public IntegerTerm(String val)
    {
        super(val, "0");
    }

    /**
     * Verifies that the current term is either a natural term or can be exactly converted
     * into one.
     *
     * This holds true when the integer is greater than zero.
     *
     * @return True if the term is a natural term or has an exact conversion to one; false
     * otherwise.
     */
    @Override
    public boolean isNatural() {
        return realValue.compareTo(BigInteger.ZERO) > 0;
    }

    /**
     * Verifies that the current term is either an integer term or can be exactly converted into
     * one.
     *
     * This always holds true for integers.
     *
     * @return True if the term is an integer term or has exact conversion to one; false otherwise.
     */
    @Override
    public boolean isInteger() {
        return true;
    }

    /**
     * Verifies that the current term is either a real term or can be exactly converted into
     * one.
     *
     * This always holds true for integers.
     *
     * @return True if the term is a real term or has an exact conversion to one; false otherwise.
     */
    @Override
    public boolean isReal() {
        return true;
    }

    /**
     * Verifies that the current term is either a gauss imaginary term or can be exactly converted
     * into one.
     *
     * This never holds true for integers.
     *
     * @return True if the term is gauss imaginary term or has an exact conversion to one; false
     * otherwise.
     */
    @Override
    public boolean isGaussImaginary() {
        return false;
    }

    /**
     * Verifies that the current term is either an imaginary term or can be exactly converted
     * into one.
     *
     * This never holds true for integers.
     *
     * @return True if the term is either an imaginary term or has exact conversion to one; false
     * otherwise.
     */
    @Override
    public boolean isImaginary() {
        return false;
    }

    @Override
    public String toString()
    {
        return realValue.toString();
    }
}
