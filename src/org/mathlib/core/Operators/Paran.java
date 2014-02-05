package org.mathlib.core.Operators;

import org.mathlib.core.Operators.Operator;

public class Paran extends Operator {
	private String paran;
	private final static int pres = 1;
	
	public Paran(String o){
		super(o,pres);
		paran = o;
	}
	
	
	public int getPrecedence() {
		return pres;
	}

	
	public String getOperator() {
		return paran;
	}
	public boolean isOpen(){
		if(paran.equals("(") || paran.equals("[") || paran.equals("{")){
            return true;
        }
		return false;
	}


	@Override

	public String toString(){
		return paran;
	}


	
	public String getToken() {
		
		return paran;
	}


	
	public int getType() {
		// TODO Auto-generated method stub
		return 1;
	}


	@Override
	public double operation(double... args) {
		// TODO Auto-generated method stub
		return 0;
	}
}
