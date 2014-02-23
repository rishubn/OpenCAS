package org.mathlib.process;
import java.util.*;
import org.mathlib.core.*;
/**
 * Created by Rishub on 2/22/14.
 */
public class ExpressionTree {

    private String post;
    private Node root;
    Stack<Node> stack;
    private String tree;

    public ExpressionTree(Postfixer p)
    {
        post = p.toString();

        stack = new Stack<Node>();

        makeTree(post);
    }

    public Node getRoot()
    {
        return root;
    }

    public void makeTree(String e)
    {

        String regex = "[\\s]";
        String[] arr = e.split(regex);
        System.out.println((post));
        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i].equals(" ")){
                continue;
            }

            if(!TokenMap.isToken(arr[i]))
            {
                stack.push(new Node(arr[i].trim()));

            }else{

                Node n = new Node(arr[i].trim());
                n.right = stack.pop();
                n.left = stack.pop();
                stack.push(n);

            }

        }


    }


    public String toString()
    {

       root = stack.pop();
       root.print("",true);

        return tree;
    }

    private void traverse(Node node){
        Node n = node;

        while(n.left != null)
        {
            n = n.left;

        }
        tree += " " +  n.toString();
    }



    public static void main(String[] args)
    {
        ExpressionTree e = new ExpressionTree(new Postfixer("(5 - x) * 7 ^ 6"));
        System.out.println(e);
    }


}








    class Node {

        Node left;
        Node right;

        String tok;

        Node(String s)
        {
            tok = s;

        }
        public String toString()
        {
            return tok;
        }
        public void print(String prefix, boolean isTail) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + tok);
                if(right != null){
                right.print(prefix + (isTail ? "    " : "│   "), false);
                }
            if (left != null) {
                left.print(prefix + (isTail ? "    " : "│   "), true);
            }
        }

    }




