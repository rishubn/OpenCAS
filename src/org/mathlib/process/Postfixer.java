/*
 * This class converts the infix input string into a postfix string which is then used as the output
 *
 * 
 * Rishub Nagpal
 * 1/5/2013
 * version 1.0
 */


package org.mathlib.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import org.mathlib.core.*;
import org.mathlib.core.Functions.Function;
import org.mathlib.core.Operators.Paran;
import org.mathlib.core.TokenMap;
import org.mathlib.exceptions.MisMatchedParenthesisException;


public class Postfixer {
    private String expression;
    private String postfix = "";
    private Stack<Token> tok;

    public Postfixer(String exp){
        PopulateMaps.Populate();
        expression = exp;
        tok = new Stack<Token>();

        try {
            makePost(expression);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public String makePost(String e) throws Exception
    {
        String regex = "(?<=op)|(?=op)".replace("op", "[-^+*%/()]");
        String[] arr = e.split(regex);

        ArrayList<String> a  = new ArrayList<String>(Arrays.asList(arr));

        for(int i = 0; i < a.size(); i++)
        {
            a.set(i, a.get(i).trim());
        }
        System.out.println(a);
        if(Character.isLetter(a.get(0).charAt(0)) && !TokenMap.isToken(a.get(0)))
        {
            a.add(0,"(");
        }
        if(Character.isLetter(a.get(a.size() -1).charAt(0)) && !TokenMap.isToken(a.get(a.size() - 1)))
        {
            a.add(")");
        }
        System.out.println(a);
        for(int i = 1; i < a.size();i++)
        {
            String s = a.get(i);
            char c = s.charAt(0);
            if(Character.isLetter(c) && !TokenMap.isToken(s))
            {


                if(a.get(i+1).equals("^"))
                {
                    a.add(i+3,")");
                    continue;
                }
                else
                {
                    if(i+1 == a.size()-1){

                        continue;
                    }
                    a.add(i+1,")");

                }
            }
        }
        for(int i = 1; i < a.size();i++)
        {
            String s = a.get(i);
            char c = s.charAt(0);
            if(Character.isLetter(c) && !TokenMap.isToken(s))
            {


                if(a.get(i-1).equals("*"))
                {
                    i++;
                    a.add(i-3,"(");
                    continue;
                }
                else
                {
                    if(i-1 == 0)
                        continue;

                    i++;
                    a.add(i-1,"(");



                }
            }
        }
   /*
   for(int i = 0; i < a.size(); i++)
    {
        String s = a.get(i);

        if(Character.isLetter(s.charAt(0)) && i == a.size() - 1)
        {
            if(a.size() == 1)
            {
                a.add(0,"(");
                a.add(")");
                continue;
            }
            if(a.get(i-1).equals("*"))
            {
                a.add(i-2,"(");
            }
            else
            {
                a.add(i-1,"(");
            }
            a.add(")");
            continue;
        }
        if(&& a.get(i+1).equals("^"))
        {
            a.add(i-1,)
            a.add(i+2,")");
        }
        else if(Character.isLetter(s.charAt(0)) && i != 0 && a.get(i-1).equals("*"))
        {

            a.add(i-2,"(");
            i++;

            if(i == a.size() - 1)
            {

                a.add(")");
            }
            else if(a.get(i+1).equals("^"))
            {

                a.add(i + 3, ")");
            }
            else
            {

                a.add(i+1,")");
            }

        }

   //System.out.println(a.get(i));
    }*/
        arr = a.toArray(new String[a.size()]);
        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++)
        {


            if(arr[i].equals(" "))
            {
                continue;
            }

            if(arr[i].equals("(")){

                tok.push(new Paran("("));
                continue;
            }
            if(!tok.isEmpty() && arr[i].equals(")")){


                while(!tok.isEmpty()){
                    Paran p = new Paran(tok.peek().toString());

                    if(!p.isOpen()){
                        postfix += " " + tok.pop();
                    }else{
                        break;
                    }
                }
                tok.pop();

            }
            Token o = TokenMap.getMap().get(arr[i].trim());

            if(o == null){

                postfix += " " + arr[i];
                continue;
            }
            if(o instanceof Function){
                tok.push(o);

                continue;
            }
            if(tok.isEmpty()){

                tok.push(o);

                continue;
            }
            else
            {
                while(((!tok.isEmpty()) && tok.peek().getType() == 2)){
                    postfix += " " + tok.pop();
                }
                while((!tok.isEmpty()  && (tok.peek().getAssoc() == 0 && (tok.peek().getPrecedence() <= o.getPrecedence())) && !(tok.peek() instanceof Paran))){

                    postfix += " " + tok.pop();
                }
                tok.push(o);
                continue;

            }

        }


        while(!tok.isEmpty())
        {
            if(tok.peek().toString().equals("(")){
                throw new MisMatchedParenthesisException();
            }
            postfix += " " + tok.pop();
        }

        postfix = postfix.replaceAll("\\s[)]","");
        postfix = postfix.trim();
        postfix = postfix.replaceAll("\\s+", " ");
        return postfix;

    }
    public String toString()
    {
        return postfix;
    }
    public static void main(String[] args)
    {

        System.out.println((new Postfixer("x^6+2*y^6")));
        //System.out.println((new Postfixer("(8 + 4) * sin(7)")));
    }



}