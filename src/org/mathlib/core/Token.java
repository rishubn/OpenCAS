package org.mathlib.core;
/*
 * This interface is the root of all core classes
 * Rishub Nagpal
 * 1/5/2014
 * version 1.0
 */
public interface Token {
	String toString();
    //returns the string form of Token, + - * etc
	int getType();
    // 0 = operators, 1 = Parenthesis, 2 = funtions
    double operation(double... args);
    //the operation itself
    public int getPrecedence();
    //returns the location in pemdas. 1 is the highest precedence.
    public void setAssoc(int i);
    //sets left or right associativity
    public int getAssoc();
    //get assoc
}
