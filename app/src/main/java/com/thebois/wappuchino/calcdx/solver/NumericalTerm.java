package com.thebois.wappuchino.calcdx.solver;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by wappuchino on 12/17/17.
 */

public class NumericalTerm extends AbstractValueTerm {
    protected BigDecimal realValue;
    protected BigDecimal imaginaryValue;

    public NumericalTerm()
    {
        realValue = imaginaryValue = BigDecimal.ZERO;
    }

    public NumericalTerm(BigInteger real, BigInteger imaginary)
    {
        realValue = new BigDecimal(real);
        imaginaryValue = new BigDecimal(imaginary);
    }

    public NumericalTerm(BigDecimal real, BigDecimal imaginary)
    {
        realValue = real;
        imaginaryValue = imaginary;
    }

    public NumericalTerm(String real, String imaginary)
    {
        realValue = new BigDecimal(real);
        imaginaryValue = new BigDecimal(imaginary);
    }

    public NumericalTerm(double real, double imaginary)
    {
        realValue = new BigDecimal(real);
        imaginaryValue = new BigDecimal(imaginary);
    }

    @Override
    public String toString()
    {
        if(isReal()) return realValue.toString();
        else if(isImaginary()) return imaginaryValue.toString().concat("i");
        else return realValue.toString().concat(imaginaryValue.compareTo(BigDecimal.ZERO) > 0 ? "+" : "")
                    .concat(imaginaryValue.equals(BigDecimal.ONE) ? "" : imaginaryValue.toString()).concat("i");
    }

    @Override
    public AbstractValueTerm evaluate(int precision) {
        return this;
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
        return isInteger() && realValue.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * Verifies that the current term is either an integer term or can be exactly converted into
     * one.
     *
     * This holds true when the imaginary component is zero and the real component is an integer.
     *
     * @return True if the term is an integer term or has exact conversion to one; false otherwise.
     */
    @Override
    public boolean isInteger() {
        return isReal() && realValue.remainder(BigDecimal.ONE).equals(BigDecimal.ZERO);
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
        return imaginaryValue.equals(BigDecimal.ZERO);
    }

    /**
     * Verifies that the current term is either a gauss imaginary term or can be exactly converted
     * into one.
     *
     * This holds true when both the real component is zero and the imaginary
     * component has an integer coefficient.
     *
     * @return True if the term is gauss imaginary term or has an exact conversion to one; false
     * otherwise.
     */
    @Override
    public boolean isGaussImaginary() {
        return isImaginary() && imaginaryValue.remainder(BigDecimal.ONE).equals(BigDecimal.ZERO);
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
        return realValue.equals(BigDecimal.ZERO);
    }

    /**
     * Verifies that the current term is either a gaussian term or can be exactly converted into
     * one.
     *
     * This holds true when both the real and complex components are of integer
     * coefficients/values.
     *
     * @return True if the term is either a gaussian term or has an exact conversion to one; false
     * otherwise.
     */
    @Override
    public boolean isGauss() {
        return realValue.remainder(BigDecimal.ONE).equals(BigDecimal.ZERO) && imaginaryValue.remainder(BigDecimal.ONE).equals(BigDecimal.ZERO);
    }

    /**
     * Verifies that current term is either a complex term or can be exactly converted into one.
     *
     * This always holds true for all values used in the solver.
     *
     * @return True if the term is either a complex term or has an exact conversion into one; false
     * otherwise.
     */
    @Override
    public boolean isComplex() {
        return true;
    }

    public AbstractValueTerm add(AbstractValueTerm o, int precision)
    {
        MathContext mc = new MathContext(precision, RoundingMode.HALF_EVEN);
        NumericalTerm other = (NumericalTerm)o;
        return new NumericalTerm(realValue.add(other.realValue, mc), imaginaryValue.add(other.imaginaryValue, mc));
    }

    public AbstractValueTerm subtract(AbstractValueTerm o, int precision)
    {
        MathContext mc = new MathContext(precision, RoundingMode.HALF_EVEN);
        NumericalTerm other = (NumericalTerm)o;
        return new NumericalTerm(realValue.subtract(other.realValue, mc), imaginaryValue.subtract(other.imaginaryValue, mc));
    }

    public AbstractValueTerm multiply(AbstractValueTerm o, int precision)
    {
        MathContext mc = new MathContext(precision, RoundingMode.HALF_EVEN);
        NumericalTerm other = (NumericalTerm)o;
        return new NumericalTerm(realValue.multiply(other.realValue, mc).subtract(imaginaryValue.multiply(other.imaginaryValue, mc), mc),
                realValue.multiply(other.imaginaryValue, mc).add(other.realValue.multiply(imaginaryValue, mc), mc));
    }

    public AbstractValueTerm divide(AbstractValueTerm o, int precision)
    {
        MathContext mc = new MathContext(precision, RoundingMode.HALF_EVEN);
        NumericalTerm other = (NumericalTerm)o;
        BigDecimal commonFactor = other.realValue.pow(2, mc).add(other.imaginaryValue.pow(2, mc), mc);
        return new NumericalTerm(realValue.multiply(other.realValue, mc).add(imaginaryValue.multiply(other.imaginaryValue, mc), mc).divide(commonFactor, mc),
                imaginaryValue.multiply(other.realValue, mc).subtract(realValue.multiply(other.imaginaryValue, mc), mc).divide(commonFactor, mc));
    }
}
