package org.mathlib.core.Functions;

/**
 * Created by Rishub on 2/5/14.
 */
public class Log extends Function{


    public Log(){
        super("log");
    }


    public double operation(double... args) {
        return (Math.log10(args[0]));
    }
}


