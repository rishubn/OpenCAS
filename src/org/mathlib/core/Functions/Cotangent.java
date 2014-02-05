package org.mathlib.core.Functions;

/**
 * Created by Rishub on 2/5/14.
 */
public class Cotangent extends Function{

        public Cotangent(){
            super("cot");
        }
        public double operation(double... args) {
            return (1/Math.tan(args[0]));
        }
    }


