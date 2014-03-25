package org.mathlib.core.Expressions;

import org.mathlib.core.Operators.Exponent;
import org.mathlib.core.Operators.Multiply;
import org.mathlib.core.Token;
import org.mathlib.core.TokenMap;
import org.mathlib.process.ExpressionTree;
import org.mathlib.process.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rishub on 2/24/14.
 */
public class Expression {

    private Variable[] varList;
    private Map<Variable,HashMap<Double,Double>> varMap;
    private String expression;
    private ExpressionTree tree;
    private int numVars;
    public Expression(String exp)
    {
         expression = exp;
         tree = new ExpressionTree(exp);

         parseVar(tree);
    }

    private void parseVar(ExpressionTree e)
    {

        Node n = e.getRoot();
        double coeff = 1;
        Object expon = new Double(1.0);
        if(n != null){
        parseVar(new ExpressionTree(n.getLeft()));
            if(Character.isLetter(n.toString().charAt(0)))
            {
                Token o = TokenMap.getTok(n.getParent().toString());

                if(o instanceof Exponent)
                {
                    Node par = n.getParent();
                    if(Character.isDigit(par.getRight().toString().charAt(0)))
                    {
                        expon = Double.parseDouble(par.getRight().toString());
                    }
                    else if(TokenMap.isToken(par.getRight().toString()))
                    {
                        //evaluate(node par.getRight())
                        return;
                    }
                    if(par.getParent() == null)
                    {
                        Variable v = new Variable(n.toString().charAt(0),coeff,expon);
                        System.out.println(v);

                    }

                    Token t = null;
                    if(par.getParent() != null)
                    {
                       t = TokenMap.getTok(par.getParent().toString());
                    }
                    if(t != null && t instanceof Multiply)
                    {
                        if(Character.isDigit(par.getParent().getLeft().toString().charAt(0)))
                        {
                            coeff = Double.parseDouble(par.getParent().getLeft().toString());
                        }
                    }
                }
                Variable v = new Variable(n.toString().charAt(0),coeff,expon);
                System.out.println(v);
            }
        parseVar(new ExpressionTree(n.getRight()));
        }

    }

     /*   if(n.hasRight())
        {
            if(Character.isLetter(n.getRight().toString().charAt(0)))
            {

                Token o = TokenMap.getMap().get(n.toString());
                if(o instanceof Exponent)
                {
                    expon = Double.parseDouble(n.getLeft().toString());

                    Node par = n.getParent();

                    Token t = TokenMap.getTok(par.toString());
                    if(t instanceof Multiply)
                    {
                           Token tl = TokenMap.getTok(par.getLeft().toString());
                           if(tl instanceof Exponent)
                           {
                                coeff = Double.parseDouble(par.getRight().toString());
                           }
                            else
                           {
                               coeff = Double.parseDouble(par.getLeft().toString());
                           }

                    }
                }
                Variable v = new Variable(n.getRight().toString().charAt(0),expon,coeff);
                System.out.println(v);
            } parseVar(new ExpressionTree(n.getRight()));
        }*/





public static void main(String[] args)
{
    Expression e = new Expression("1 / 5*x^3");
}








}
