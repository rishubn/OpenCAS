package org.mathlib.core.Functions;

import org.mathlib.core.Token;

public abstract class Function implements Token {


	private String function;
	private static final int precedence = 1;
    private static final int assoc = 0;
	public Function(String f){
		

		function = f;

		
	}

	public String toString(){
		return function;
	}
	public boolean isParan(){
		return false;
	}
	public boolean isOpen(){
		return false;
	}
    public int getPrecedence() {
        return precedence;
    }
    public void setAssoc(int i){
        return;
    }
    public int getAssoc(){
        return assoc;
    }

	public int getType() {
		
		return 2;
	}

}
