package org.mathlib.core.Operators;

import org.mathlib.core.Operators.Operator;

public class Exponent extends Operator {

	public Exponent() {
		super("^", 2);
		setAssoc(0);
		
	}

	@Override
	public double operation(double... args) {
		return Math.pow(args[1], args[0]);
	}

}
