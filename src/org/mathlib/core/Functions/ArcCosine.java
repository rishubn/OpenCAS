package org.mathlib.core.Functions;


public class ArcCosine extends Function {
    public ArcCosine(){
        super("acos");
    }
    public double operation(double ... args){
        return Math.acos(args[0]);
    }


}
