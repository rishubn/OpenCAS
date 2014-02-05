package org.mathlib.core.Operators;

import org.mathlib.core.Operators.Operator;

public class Division extends Operator {
	public Division(){
		super("/",3);
	}

	@Override
	public double operation(double... args) {
		return args[1] / args[0];
	}
	
}
