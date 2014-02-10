package org.mathlib.core.Functions;

/**
 * Created by Rishub on 2/6/14.
 */
public class SqRoot extends Function{
    public SqRoot(){
        super("sqrt");
    }

    @Override
    public double operation(double... args) {
        return Math.sqrt(args[0]);
    }
}
