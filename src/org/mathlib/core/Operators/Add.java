package org.mathlib.core.Operators;

import org.mathlib.core.Operators.Operator;

public class Add extends Operator {


	public Add() {
		super("+", 4);
	}

	public double operation(double... args) {
		return args[0] + args[1]; 
	}


}
