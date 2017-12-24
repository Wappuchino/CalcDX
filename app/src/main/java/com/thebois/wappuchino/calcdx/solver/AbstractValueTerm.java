/*
 ***************************************************************************************************
 * The ValueTerm is a base type for any term which is intended to represent a value whether        *
 * numeric or symbolic. The general contract for all value terms is that they have no child        *
 * terms as child terms are normally reserved for operators with operands.                         *
 *                                                                                                 *
 * - Wappuchino                                                                                    *
 **************************************************************************************************/

package com.thebois.wappuchino.calcdx.solver;

/**
 * The value term is an abstract class denoting all terms which should represent a value such as
 * a number or symbol.
 *
 * The value term still follows the contract of the ITerm interface and provides
 * implementation for the get children functionality (since values are not expected to have
 * any child terms). It also provides access to functions that attempt to convert the value term
 * to another type of value term.
 */

public abstract class AbstractValueTerm extends AbstractTerm {
    /**
     * The default constructor of the value term class.
     *
     * The constructor ensures that the backing storage array is of size zero so that the term
     * has zero children.
     */
    protected AbstractValueTerm()
    {
        //Calls the default constructor of abstract term to force the maximum number of children
        //that can be stored to be zero.
        super();
    }

    /**
     * Converts the current value term to a natural number term, truncating and discarding
     * components as needed.
     *
     * @return The term as a natural term or the closest natural number approximation
     */
    public abstract NaturalTerm toNatural();

    /**
     * Converts the current value term to an integer number term, truncating and discarding
     * components as needed.
     *
     * @return The term as an integer or the closest integer approximation
     */
    public abstract IntegerTerm toInteger();

    /**
     * Converts the current value term to an real number term, discarding components as needed.
     *
     * @return The term as a real or the closest real approximation
     */
    public abstract RealTerm toReal();

    /**
     * Converts the current value term to a gauss imaginary term, truncating and discarding
     * components as needed.
     *
     * @return The term as a gauss imaginary or the closest gauss imaginary approximation
     */
    public abstract GaussImaginaryTerm toGaussImaginary();

    /**
     * Converts the current value term to an imaginary term, discarding components
     * as needed.
     *
     * @return The term as an imaginary term or the closest imaginary approximation
     */
    public abstract ImaginaryTerm toImarginary();

    /**
     * Converts the current value term to a gaussian term, discarding components as needed.
     *
     * @return The term as a gaussian term or the closest gaussian approximation
     */
    public abstract GaussianTerm toGauss();

    /**
     * Converts the current value term to a complex term; discarding components as needed.
     *
     * @return The term as a complex term or the closest complex approximation
     */
    public abstract ComplexTerm toComplex();



    /**
     * Converts the current value term to a natural term, throwing an exception if an exact
     * conversion cannot be made.
     *
     * @return The term as a natural term
     * @exception ArithmeticException An exact conversion does not exist
     */
    public abstract NaturalTerm toNaturalExact();

    /**
     * Converts the current value term to an integer term, throwing an exception if an exact
     * conversion cannot be made.
     *
     * @return The term as an integer term
     * @exception ArithmeticException An exact conversion does not exist
     */
    public abstract IntegerTerm toIntegerExact();

    /**
     * Converts the current value term to a real term, throwing an exception if an exact
     * conversion cannot be made.
     *
     * @return The term as a real term
     * @exception ArithmeticException An exact conversion does not exist
     */
    public abstract RealTerm toRealExact();

    /**
     * Converts the current value term to a gaussian imaginary term, throwing an exception if
     * an exact conversion cannot be made.
     *
     * @return The term as a gaussian imaginary term
     * @exception ArithmeticException An exact conversion does not exist
     */
    public abstract GaussImaginaryTerm toGaussImaginaryExact();

    /**
     * Converts the current value term to an imaginary term, throwing an exception if an
     * exact conversion cannot be made.
     *
     * @return The term as an imaginary term
     * @exception ArithmeticException An exact conversion cannot be made
     */
    public abstract ImaginaryTerm toImaginaryExact();

    /**
     * Converts the current value term to a gaussian term, throwing an exception if an
     * exact conversion cannot be made.
     *
     * @return The term as a gaussian term
     * @exception ArithmeticException An exact conversion cannot be made
     */
    public abstract GaussianTerm toGaussExact();

    /**
     * Converts the current value to a complex term, throwing an exception if an exact
     * conversion cannot be made.
     *
     * @return The term as a complex term.
     * @exception ArithmeticException An exact conversion cannot be made
     */
    public abstract ComplexTerm toComplexExact();



    /**
     * Verifies that the current term is either a natural term or can be exactly converted
     * into one.
     *
     * @return True if the term is a natural term or has an exact conversion to one; false
     * otherwise.
     */
    public abstract boolean isNatural();

    /**
     * Verifies that the current term is either an integer term or can be exactly converted into
     * one.
     *
     * @return True if the term is an integer term or has exact conversion to one; false otherwise.
     */
    public abstract boolean isInteger();

    /**
     * Verifies that the current term is either a real term or can be exactly converted into
     * one.
     *
     * @return True if the term is a real term or has an exact conversion to one; false otherwise.
     */
    public abstract boolean isReal();

    /**
     * Verifies that the current term is either a gauss imaginary term or can be exactly converted
     * into one.
     *
     * @return True if the term is gauss imaginary term or has an exact conversion to one; false
     * otherwise.
     */
    public abstract boolean isGaussImaginary();

    /**
     * Verifies that the current term is either an imaginary term or can be exactly converted
     * into one.
     *
     * @return True if the term is either an imaginary term or has exact conversion to one; false
     * otherwise.
     */
    public abstract boolean isImaginary();

    /**
     * Verifies that the current term is either a gaussian term or can be exactly converted into
     * one.
     *
     * @return True if the term is either a gaussian term or has an exact conversion to one; false
     * otherwise.
     */
    public abstract boolean isGauss();

    /**
     * Verifies that current term is either a complex term or can be exactly converted into one.
     *
     * @return True if the term is either a complex term or has an exact conversion into one; false
     * otherwise.
     */
    public abstract boolean isComplex();
}
