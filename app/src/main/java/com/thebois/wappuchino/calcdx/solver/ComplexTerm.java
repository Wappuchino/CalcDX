package com.thebois.wappuchino.calcdx.solver;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by wappuchino on 12/17/17.
 */

public class ComplexTerm extends AbstractValueTerm {
    protected BigDecimal realValue;
    protected BigDecimal imaginaryValue;

    public ComplexTerm()
    {
        realValue = imaginaryValue = BigDecimal.ZERO;
    }

    public ComplexTerm(BigInteger real, BigInteger imaginary)
    {
        realValue = new BigDecimal(real);
        imaginaryValue = new BigDecimal(imaginary);
    }

    public ComplexTerm(BigDecimal real, BigDecimal imaginary)
    {
        realValue = real;
        imaginaryValue = imaginary;
    }

    public ComplexTerm(String real, String imaginary)
    {
        realValue = new BigDecimal(real);
        imaginaryValue = new BigDecimal(imaginary);
    }

    public ComplexTerm(double real, double imaginary)
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

    //TODO
    /**
     * Converts the current value term to a natural number term, truncating and discarding
     * components as needed.
     *
     * @return The term as a natural term or the closest natural number approximation
     */
    @Override
    public NaturalTerm toNatural() {
        return null;
    }

    /**
     * Converts the current value term to an integer number term, truncating and discarding
     * components as needed.
     *
     * @return The term as an integer or the closest integer approximation
     */
    @Override
    public IntegerTerm toInteger() {
        return null;
    }

    /**
     * Converts the current value term to an real number term, discarding components as needed.
     *
     * @return The term as a real or the closest real approximation
     */
    @Override
    public RealTerm toReal() {
        return null;
    }

    /**
     * Converts the current value term to a gauss imaginary term, truncating and discarding
     * components as needed.
     *
     * @return The term as a gauss imaginary or the closest gauss imaginary approximation
     */
    @Override
    public GaussImaginaryTerm toGaussImaginary() {
        return null;
    }

    /**
     * Converts the current value term to an imaginary term, discarding components
     * as needed.
     *
     * @return The term as an imaginary term or the closest imaginary approximation
     */
    @Override
    public ImaginaryTerm toImarginary() {
        return null;
    }

    /**
     * Converts the current value term to a gaussian term, discarding components as needed.
     *
     * @return The term as a gaussian term or the closest gaussian approximation
     */
    @Override
    public GaussianTerm toGauss() {
        return null;
    }

    /**
     * Converts the current value term to a complex term; discarding components as needed.
     *
     * @return The term as a complex term or the closest complex approximation
     */
    @Override
    public ComplexTerm toComplex() {
        return null;
    }

    /**
     * Converts the current value term to a natural term, throwing an exception if an exact
     * conversion cannot be made.
     *
     * @return The term as a natural term
     * @throws ArithmeticException An exact conversion does not exist
     */
    @Override
    public NaturalTerm toNaturalExact() {
        return null;
    }

    /**
     * Converts the current value term to an integer term, throwing an exception if an exact
     * conversion cannot be made.
     *
     * @return The term as an integer term
     * @throws ArithmeticException An exact conversion does not exist
     */
    @Override
    public IntegerTerm toIntegerExact() {
        return null;
    }

    /**
     * Converts the current value term to a real term, throwing an exception if an exact
     * conversion cannot be made.
     *
     * @return The term as a real term
     * @throws ArithmeticException An exact conversion does not exist
     */
    @Override
    public RealTerm toRealExact() {
        return null;
    }

    /**
     * Converts the current value term to a gaussian imaginary term, throwing an exception if
     * an exact conversion cannot be made.
     *
     * @return The term as a gaussian imaginary term
     * @throws ArithmeticException An exact conversion does not exist
     */
    @Override
    public GaussImaginaryTerm toGaussImaginaryExact() {
        return null;
    }

    /**
     * Converts the current value term to an imaginary term, throwing an exception if an
     * exact conversion cannot be made.
     *
     * @return The term as an imaginary term
     * @throws ArithmeticException An exact conversion cannot be made
     */
    @Override
    public ImaginaryTerm toImaginaryExact() {
        return null;
    }

    /**
     * Converts the current value term to a gaussian term, throwing an exception if an
     * exact conversion cannot be made.
     *
     * @return The term as a gaussian term
     * @throws ArithmeticException An exact conversion cannot be made
     */
    @Override
    public GaussianTerm toGaussExact() {
        return null;
    }

    /**
     * Converts the current value to a complex term, throwing an exception if an exact
     * conversion cannot be made.
     *
     * @return The term as a complex term.
     * @throws ArithmeticException An exact conversion cannot be made
     */
    @Override
    public ComplexTerm toComplexExact() {
        return null;
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
}
