package org.mathlib.core.Functions;


public class Sine extends Function {
    public Sine(){
        super("sin");
    }
	public double operation(double ... args){
        return Math.sin(args[0]);
    }


}
