package org.mathlib.core.Functions;


public class ArcTangent extends Function {
    public ArcTangent(){
        super("atan");
    }
    public double operation(double ... args){
        return Math.atan(args[0]);
    }


}
