package com.thebois.wappuchino.calcdx.solver;

import java.math.BigInteger;

/**
 * Created by wappuchino on 12/17/17.
 */

public class GaussImaginaryTerm extends GaussianTerm {

    public GaussImaginaryTerm()
    {
        super();
    }

    public GaussImaginaryTerm(long val)
    {
        super(0, val);
    }

    public GaussImaginaryTerm(BigInteger val)
    {
        super(BigInteger.ZERO, val);
    }

    /**
     * Verifies that the current term is either a natural term or can be exactly converted
     * into one.
     *
     * This never holds true for gauss imaginary terms.
     *
     * @return True if the term is a natural term or has an exact conversion to one; false
     * otherwise.
     */
    @Override
    public boolean isNatural() {
        return false;
    }

    /**
     * Verifies that the current term is either an integer term or can be exactly converted into
     * one.
     *
     * This never holds true for gauss imaginary terms.
     *
     * @return True if the term is an integer term or has exact conversion to one; false otherwise.
     */
    @Override
    public boolean isInteger() {
        return false;
    }

    /**
     * Verifies that the current term is either a real term or can be exactly converted into
     * one.
     *
     * This never holds true for gauss imaginary terms.
     *
     * @return True if the term is a real term or has an exact conversion to one; false otherwise.
     */
    @Override
    public boolean isReal() {
        return false;
    }

    /**
     * Verifies that the current term is either a gauss imaginary term or can be exactly converted
     * into one.
     *
     * This always holds true for gauss imaginary terms.
     *
     * @return True if the term is gauss imaginary term or has an exact conversion to one; false
     * otherwise.
     */
    @Override
    public boolean isGaussImaginary() {
        return true;
    }

    /**
     * Verifies that the current term is either an imaginary term or can be exactly converted
     * into one.
     *
     * This always holds true for gauss imaginary terms.
     *
     * @return True if the term is either an imaginary term or has exact conversion to one; false
     * otherwise.
     */
    @Override
    public boolean isImaginary() {
        return true;
    }
}
