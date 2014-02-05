package org.mathlib.core.Functions;

/**
 * Created by Rishub on 2/5/14.
 */
public class Cosecant extends Function{
    public Cosecant(){
        super("csc");
    }

    @Override
    public double operation(double... args) {
        return (1/Math.sin(args[0]));
    }
}
