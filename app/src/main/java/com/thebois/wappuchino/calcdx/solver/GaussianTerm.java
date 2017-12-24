package com.thebois.wappuchino.calcdx.solver;

import java.math.BigInteger;

/**
 * Created by wappuchino on 12/17/17.
 */

public class GaussianTerm extends ComplexTerm {
    protected BigInteger realValue;
    protected BigInteger imaginaryValue;

    public GaussianTerm()
    {
        realValue = imaginaryValue = BigInteger.ZERO;
    }

    public GaussianTerm(BigInteger real, BigInteger imaginary)
    {
        super(real, imaginary);
        realValue = real;
        imaginaryValue = imaginary;
    }

    public GaussianTerm(String real, String imaginary)
    {
        super(real, imaginary);
        realValue = new BigInteger(real);
        imaginaryValue = new BigInteger(imaginary);
    }

    public GaussianTerm(long real, long imaginary)
    {
        super(real, imaginary);
        realValue = BigInteger.valueOf(real);
        imaginaryValue = BigInteger.valueOf(imaginary);
    }

    /**
     * Verifies that the current term is either a natural term or can be exactly converted
     * into one.
     *
     * This holds true when the imaginary component is zero and the real component is a positive
     * integer.
     *
     * @return True if the term is a natural term or has an exact conversion to one; false
     * otherwise.
     */
    @Override
    public boolean isNatural() {
        return isInteger() && realValue.compareTo(BigInteger.ZERO) > 0;
    }

    /**
     * Verifies that the current term is either an integer term or can be exactly converted into
     * one.
     *
     * This holds true when the imaginary component is zero.
     *
     * @return True if the term is an integer term or has exact conversion to one; false otherwise.
     */
    @Override
    public boolean isInteger() {
        return imaginaryValue.equals(BigInteger.ZERO);
    }

    /**
     * Verifies that the current term is either a real term or can be exactly converted into
     * one.
     *
     * This holds true when the imaginary component is zero.
     *
     * @return True if the term is a real term or has an exact conversion to one; false otherwise.
     */
    @Override
    public boolean isReal() {
        return imaginaryValue.equals(BigInteger.ZERO);
    }

    /**
     * Verifies that the current term is either a gauss imaginary term or can be exactly converted
     * into one.
     *
     * For gaussian terms, this holds true when the real component is zero.
     *
     * @return True if the term is gauss imaginary term or has an exact conversion to one; false
     * otherwise.
     */
    @Override
    public boolean isGaussImaginary() {
        return realValue.equals(BigInteger.ZERO);
    }

    /**
     * Verifies that the current term is either an imaginary term or can be exactly converted
     * into one.
     *
     * This holds true when the real component is zero.
     *
     * @return True if the term is either an imaginary term or has exact conversion to one; false
     * otherwise.
     */
    @Override
    public boolean isImaginary() {
        return realValue.equals(BigInteger.ZERO);
    }

    /**
     * Verifies that the current term is either a gaussian term or can be exactly converted into
     * one.
     *
     * This always holds true for gaussian terms.
     *
     * @return True if the term is either a gaussian term or has an exact conversion to one; false
     * otherwise.
     */
    @Override
    public boolean isGauss() {
        return true;
    }

    @Override
    public String toString()
    {
        if(isReal()) return realValue.toString();
        else if(isImaginary()) return imaginaryValue.toString().concat("i");
        else return realValue.toString().concat(imaginaryValue.compareTo(BigInteger.ZERO) > 0 ? "+" : "")
                    .concat(imaginaryValue.equals(BigInteger.ONE) ? "" : imaginaryValue.toString()).concat("i");
    }
}
