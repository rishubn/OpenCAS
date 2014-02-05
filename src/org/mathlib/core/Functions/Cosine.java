package org.mathlib.core.Functions;

/**
 * Created by Rishub on 2/5/14.
 */
public class Cosine extends Function {

    public Cosine(){
        super("cos");
    }

    @Override
    public double operation(double... args) {
        return Math.cos(args[0]);
    }
}
