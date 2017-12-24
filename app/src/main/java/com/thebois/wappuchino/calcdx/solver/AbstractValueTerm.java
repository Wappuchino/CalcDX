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

    public abstract AbstractValueTerm add(AbstractValueTerm other, int precision);
    public abstract AbstractValueTerm subtract(AbstractValueTerm other, int precision);
    public abstract AbstractValueTerm multiply(AbstractValueTerm other, int precision);
    public abstract AbstractValueTerm divide(AbstractValueTerm other, int precision);

}
