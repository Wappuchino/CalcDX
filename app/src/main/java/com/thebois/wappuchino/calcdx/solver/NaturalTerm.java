/*
 ***************************************************************************************************
 * The NaturalTerm is subtype of the value term that represents any natural number.                *
 *                                                                                                 *
 * Like most value terms, it has no children.                                                      *
 *                                                                                                 *
 * - Wappuchino                                                                                    *
 **************************************************************************************************/

package com.thebois.wappuchino.calcdx.solver;

import java.math.BigInteger;

/**
 * Created by wappuchino on 12/17/17.
 */
public class NaturalTerm extends IntegerTerm {
    public NaturalTerm()
    {
        super(1);
    }

    public NaturalTerm(long val)
    {
        super(val == 0 ? 1 : val < 0 ? val == Long.MIN_VALUE ? Long.MAX_VALUE : -val : val);
    }

    public NaturalTerm(BigInteger val)
    {
        super(val.equals(BigInteger.ZERO) ? BigInteger.ONE : val.compareTo(BigInteger.ZERO) < 0 ? val.negate() : val);
    }

    public NaturalTerm(String val)
    {
        this(new BigInteger(val));
    }

    /**
     * Verifies that the current term is either a natural term or can be exactly converted
     * into one.
     *
     * This always holds true for natural numbers.
     *
     * @return True if the term is a natural term or has an exact conversion to one; false
     * otherwise.
     */
    @Override
    public boolean isNatural() {
        return true;
    }
}
