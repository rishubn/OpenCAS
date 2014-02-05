package org.mathlib.core.Operators;

import org.mathlib.core.Token;

public abstract class Operator implements Token {


	private String operator;
	private int precedence;
	private int assoc = 0;

	public Operator(String o, int p){
		

		operator = o;
		precedence = p;

		
	}
	
	public abstract double operation(double... args);

	

	public int getPrecedence() {
		return precedence;
	}
	public void setAssoc(int i){
		assoc = i;
	}
	public int getAssoc(){
		return assoc;
	}

	public String toString(){ return operator; }

	public boolean isOpen(){ return false; }

	public int getType() { return 0; }

}
