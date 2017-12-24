package com.thebois.wappuchino.calcdx.solver;

/**
 * Created by wappuchino on 12/23/17.
 */

public abstract class AbstractBinaryOperator extends AbstractOperatorTerm {
    public AbstractBinaryOperator(int prec)
    {
        super(prec, 2);
    }

    public AbstractBinaryOperator(int prec, ITerm left, ITerm right)
    {
        this(prec);
        children[0] = left;
        children[1] = right;
    }
}
