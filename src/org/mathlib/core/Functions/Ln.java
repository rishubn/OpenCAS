package org.mathlib.core.Functions;

/**
 * Created by Rishub on 2/5/14.
 */
public class Ln extends Function{


        public Ln(){
            super("ln");
        }


        public double operation(double... args) {
            return (Math.log(args[0]));
        }
    }


