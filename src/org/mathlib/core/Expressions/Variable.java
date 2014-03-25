package org.mathlib.core.Expressions;

/**
 * Created by Rishub on 2/24/14.
 */
public class Variable {

    private char name;
    private Double coefficient;
    private Object exponent;
    private Double value;

    public Variable(char n,Double c, Object e)
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


    public Double getCoefficient() {
        return coefficient;
    }
    public void setValue(double d) { value = d; }
    public Object getExponent() {
        return exponent;
    }

    public Double getValue() {
        return value;
    }

    public char getName() {

        return name;
    }

    public String toString()
    {
        return coefficient + " * " + name + "^" + exponent;
    }

}
