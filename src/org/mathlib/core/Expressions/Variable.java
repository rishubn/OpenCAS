package org.mathlib.core.Expressions;

/**
 * Created by Rishub on 2/24/14.
 */
public class Variable {

    private char name;
    private double coefficient;
    private double exponent;
    private double value;

    public Variable(char n,double c, double e)
    {
        name = n;
        coefficient = c;
        exponent = e;
    }

    public Variable(char n,double v,double c, double e)
    {
        name = n;
        value = v;
        coefficient = c;
        exponent = e;
    }


    public double getCoefficient() {
        return coefficient;
    }
    public void setValue(double d) { value = d; }
    public double getExponent() {
        return exponent;
    }

    public double getValue() {
        return value;
    }

    public char getName() {

        return name;
    }

    public String toString()
    {
        return coefficient + "*" + name + "^" + exponent;
    }

}
