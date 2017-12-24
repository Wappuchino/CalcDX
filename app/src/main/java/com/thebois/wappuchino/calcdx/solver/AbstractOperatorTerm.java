package com.thebois.wappuchino.calcdx.solver;

/**
 * Created by wappuchino on 12/24/17.
 */

public abstract class AbstractOperatorTerm extends AbstractTerm {
    protected int precedence;
    protected AbstractOperatorTerm(int prec, int size)
    {
        super(size);
        precedence = prec;
    }
}
