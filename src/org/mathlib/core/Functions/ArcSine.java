package org.mathlib.core.Functions;


public class ArcSine extends Function {
    public ArcSine(){
        super("asin");
    }
    public double operation(double ... args){
        return Math.asin(args[0]);
    }


}
