package org.mathlib.core.Expressions;


import java.util.*;


/**
 * Created by Rishub on 4/9/14.
 */
public class Polynomial
{

    private Variable[] vars;
    private double order;
    private Map<Double,Double> map;
    private double[] expons;
    private char name;
    public Polynomial(Variable[] vList)
    {
        vars = new Variable[vList.length];
        vars = vList;

        expons = new double[vars.length];
        map = new TreeMap<Double, Double>();
        for(int i = 0; i < vars.length; i++)
        {
            map.put(vars[i].getExponent(),vars[i].getCoefficient());
            expons[i] = vars[i].getExponent();
        }
        name = vars[0].getName();

    }
    public double[] getExpons()
    {
        return expons;
    }
    public char getName(){ return name; }
    public double getCoeff(double exp)
    {
        return map.get(exp).doubleValue();
    }
    public static Polynomial add(Polynomial p1, Polynomial p2)
    {
        double[] e1 = p1.getExpons();
        double[] e2 = p2.getExpons();
        ArrayList<Variable> v = new ArrayList<Variable>();
        if(e1.length <= e2.length)
        {

            for(int i = e1.length-1; i >= 0; i--)
            {
                if(e2[i] == e1[i])
                {
                    v.add(new Variable(p1.getName(), p1.getCoeff(e2[i]) + p2.getCoeff(e1[i]), e2[i]));
                }
            }
        }
        else
        {
            for(int i = e2.length-1; i >= 0; i--)
            {
                if(e2[i] == e1[i])
                {
                    v.add(new Variable(p1.getName(), p1.getCoeff(e2[i]) + p2.getCoeff(e1[i]), e2[i]));
                }

            }

        }
        Variable[] vp =  new Variable[v.size()];
        System.arraycopy(v.toArray(),0,vp,0,vp.length);
        return new Polynomial(vp);

    }











public String toString()
{
    String out = "";
    for(int i =0; i < vars.length; i++)
    {
        if(i != 0)
            out+= " + ";


        out+= vars[i].toString();
    }
    return out;
}

  public static void main(String[] args)
  {
      Polynomial p = new Polynomial(new Variable[]
              {
                      new Variable('x',1,4), new Variable('x',2,3)
              });
      Polynomial p2 = new Polynomial(new Variable[]
              {
                      new Variable('x',2,4), new Variable('x',2,3)
              });
      Polynomial p3 = p.add(p, p2);
      System.out.println(p3.toString());

  }





























}
