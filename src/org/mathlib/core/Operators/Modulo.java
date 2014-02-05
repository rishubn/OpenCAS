package org.mathlib.core.Operators;

import org.mathlib.core.Operators.Operator;

public class Modulo extends Operator {

		public Modulo() {
			super("%", 3);
		}

		public double operation(double... args) {
			return args[1] % args[0]; 
		}

}


