package org.mathlib.core.Functions;


public class AbsoluteValue extends Function {
    public AbsoluteValue(){
        super("abs");
    }
    public double operation(double ... args){
        return Math.abs(args[0]);
    }


}
