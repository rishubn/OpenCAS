package org.mathlib.core.Functions;

/**
 * Created by Rishub on 2/5/14.
 */
public class Tangent extends Function{
    public Tangent(){
        super("tan");
    }
    @Override
    public double operation(double... args) {
        return Math.tan(args[0]);
    }


}
