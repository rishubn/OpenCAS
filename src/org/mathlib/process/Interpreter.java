

/*
 * This class solves the postfix expression
 * 
 * Rishub Nagpal
 * 1/5/2014
 * version 1.0
 */








package org.mathlib.process;
import java.util.Stack;
import org.mathlib.core.Functions.Function;
import org.mathlib.core.*;

public class Interpreter 
{
	private Stack<Double> stack;
	private double result;
	
	public Interpreter()
	{
		stack = new Stack<Double>();
		result = 0;
	}
	
	
	public double interpret(Postfixer p)
	{
		String e = p.toString();
		double one;
		double two;
		String[] arr = e.split(" ");
		
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i].equals(""))
			{
		
				continue;
			}
			
			Token o = TokenMap.getMap().get(arr[i]);
			if(o == null)
			{
				stack.push(Double.parseDouble(arr[i]));
			}
            else if(o instanceof Function)
            {
                stack.push(o.operation(stack.pop()));
            }

			else
			{
				if(stack.size() <= 1)
				{
					one = stack.peek();
					two = stack.pop();
				}
				else
				{
				one = stack.pop();
				two = stack.pop();
				}
				stack.push(o.operation(one,two));
			}
			
			
			
			
		}
		result = stack.peek();
		return result;
		
		
	}
	
	public static void main(String args[]){
		PopulateMaps.Populate();
		Interpreter i = new Interpreter();
		System.out.println(i.interpret(new Postfixer("8/2 + 4/5")));
	}
}
