
/*
 * This class converts the infix input string into a postfix string which is then used as the output
 *
 * 
 * Rishub Nagpal
 * 1/5/2013
 * version 1.0
 */


package org.mathlib.process;

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

            while((!tok.isEmpty()  && (tok.peek().getAssoc() == 1 && (tok.peek().getPrecedence() <= o.getPrecedence())) && !(tok.peek() instanceof Paran))){

                postfix += " " + tok.pop();
            }
            tok.push(o);
            continue;

        }

    }
    System.out.println(tok);

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
	public String toString(){
		return postfix;
	}
public static void main(String[] args){
	PopulateMaps.Populate();
	System.out.println((new Postfixer("(sin(abs(cos(6 ^ 2))) + 3")));
    //System.out.println((new Postfixer("(8 + 4) * sin(7)")));
}

	
	
}
