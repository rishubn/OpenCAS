package org.mathlib.core.Functions;

/**
 * Created by Rishub on 2/5/14.
 */
public class Secant extends Function{
    public Secant(){
        super("sec");
    }

    @Override
    public double operation(double... args) {
        return (1/Math.cos(args[0]));
    }
}
