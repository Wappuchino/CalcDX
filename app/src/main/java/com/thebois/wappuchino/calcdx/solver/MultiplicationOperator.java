package com.thebois.wappuchino.calcdx.solver;

/**
 * Created by wappuchino on 12/24/17.
 */

public class MultiplicationOperator extends AbstractBinaryOperator {
    public MultiplicationOperator()
    {
        super(11);
    }

    public MultiplicationOperator(ITerm left, ITerm right)
    {
        super(11, left, right);
    }

    /**
     * Evaluates a term numerically and then returns the result.
     * <p>
     * The result is a ValueTerm object of a numeric term type that is guaranteed to have exactly
     * the given precision. The value type generally is of integer, real, imaginary,
     * complex, natural, quaternion, or symbolic term type.
     * Any ties that arise in rounding will be broken to the nearest even number.
     *
     * @param precision The number of decimal digits of precision that should be used in all
     *                  calculations
     * @return A BigDecimal object representing the result of evaluating the term numerically
     */
    @Override
    public AbstractValueTerm evaluate(int precision) {
        return children[0].evaluate(precision).multiply(children[1].evaluate(precision), precision);
    }
}
