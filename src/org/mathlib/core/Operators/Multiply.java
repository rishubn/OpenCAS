package org.mathlib.core.Operators;

import org.mathlib.core.Operators.Operator;

public class Multiply extends Operator {

	public Multiply(){
		super("*",3);
	}

	@Override
	public double operation(double... args) {
		return args[0] * args[1];
	}



}
