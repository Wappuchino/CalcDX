/*
 ***************************************************************************************************
 * The ITerm is a base type that represents any term that could appear in a mathematical           *
 * expression.                                                                                     *
 *                                                                                                 *
 * The term provides access to functions that evaluate the term numerically                        *
 * and return a string representation of the term.                                                 *
 *                                                                                                 *
 * The terms also form a parse tree as the terms can have children terms which (in most cases)     *
 * represent operands and the like. Note that the first term of an expression is always the root   *
 * of the parse tree. Access to children is exposed through this interface.                        *
 *                                                                                                 *
 * - Wappuchino                                                                                    *
 **************************************************************************************************/

package com.thebois.wappuchino.calcdx.solver;

import java.math.BigDecimal;

/**
 * The ITerm interface which exposes functionality for making a string representation of a term,
 * and evaluating a term numerically.
 */
interface ITerm
{
    /**
     * Evaluates a term numerically and then returns the result.
     *
     * The result is a ValueTerm object of a numeric term type that is guaranteed to have exactly
     * the given precision. The value type generally is of integer, real, imaginary,
     * complex, natural, quaternion, or symbolic term type.
     * Any ties that arise in rounding will be broken to the nearest even number.
     *
     * @param precision The number of decimal digits of precision that should be used in all
     *                  calculations
     * @return A BigDecimal object representing the result of evaluating the term numerically
     */
    AbstractValueTerm evaluate(int precision);

    /**
     * Gets a view children of the term. Modifications to this view are neither guaranteed to modify
     * or not modify the children of the term.
     *
     * In most cases, the children of the term denote the operands of the term if it is an
     * operation term. However, soem terms may have no children or a variable number of children.
     *
     * @return A view of the children of the term
     */
    ITerm[] getChildren();
}