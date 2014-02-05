package org.mathlib.core.Operators;

import org.mathlib.core.Operators.Operator;

public class Subtract extends Operator {

	public Subtract(){
		super("-",4);
	}
	public double operation(double... args) {
		return args[1] - args[0];
	}

}
