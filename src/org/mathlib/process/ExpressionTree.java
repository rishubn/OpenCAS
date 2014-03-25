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



    public ExpressionTree(Postfixer p)
    {
        post = p.toString();

        stack = new Stack<Node>();

        makeTree(post);
    }
    public ExpressionTree(String exp)
    {
        post = new Postfixer(exp).toString();
        stack = new Stack<Node>();
        makeTree(post);


    }
    public ExpressionTree(Node n)
    {
        stack = new Stack<Node>();
        root = n;
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
                n.setRight(stack.pop());
                if(stack.isEmpty())
                {
                    root = n;
                    return;
                }
                n.setLeft(stack.pop());
                n.getRight().setParent(n);
                n.getLeft().setParent(n);
                stack.push(n);

            }

        }
        root = stack.pop();


    }
    public void traverse(Node node){

        if(node != null){

        traverse (node.getLeft());
            System.out.print(node);
        traverse(node.getRight());

    }
    }



    public static void main(String[] args)
    {
        ExpressionTree e = new ExpressionTree(new Postfixer("3*x^2+4*x^2"));
        e.traverse(e.getRoot());
    }


}












