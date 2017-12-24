/*
 ***************************************************************************************************
 * The RealTerm is subtype of the value term that represents any real number.                      *
 *                                                                                                 *
 * Like most value terms, it has no children.                                                      *
 *                                                                                                 *
 * - Wappuchino                                                                                    *
 **************************************************************************************************/

package com.thebois.wappuchino.calcdx.solver;

import java.math.BigDecimal;

/**
 * The RealTerm is a type representing any real numerical value.
 *
 * The class follows the contract of value terms having no children.
 */

public class RealTerm extends ComplexTerm {
    public RealTerm()
    {
        super();
    }

    public RealTerm(double val)
    {
        super(val, 0);
    }

    public RealTerm(BigDecimal val)
    {
        super(val, BigDecimal.ZERO);
    }

    public RealTerm(String val)
    {
        super(val, "0");
    }
}
