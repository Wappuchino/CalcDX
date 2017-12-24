package com.thebois.wappuchino.calcdx.solver;

/**
 * Created by wappuchino on 12/23/17.
 */

public class AdditionOperator extends AbstractBinaryOperator {
    public AdditionOperator()
    {
        super(10);
    }

    public AdditionOperator(ITerm left, ITerm right)
    {
        super(10, left, right);
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
        return children[0].evaluate(precision).add(children[1].evaluate(precision), precision);
    }
}
