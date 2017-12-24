package com.thebois.wappuchino.calcdx.solver;

import java.math.BigDecimal;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

/**
 * Created by wappuchino on 12/17/17.
 */

public class ImaginaryTerm extends ComplexTerm {
    public ImaginaryTerm()
    {
        super();
    }

    public ImaginaryTerm(double val)
    {
        super(0, val);
    }

    public ImaginaryTerm(BigDecimal val)
    {
        super(BigDecimal.ZERO, val);
    }

    public ImaginaryTerm(String val)
    {
        super("0", val);
    }
}
