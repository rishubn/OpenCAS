

package org.mathlib.process;

public class Node {

    private Node left;
    private Node right;
    private Node parent;
    private String tok;
    private Node[] list = new Node[2];
    Node(String s)
    {
        tok = s;

    }
    public String toString()
    {
        return tok;
    }
    public void setParent(Node n)
    {
        parent = n;
    }
    public Node getParent()
    { return parent; }
    public void setLeft(Node left) {
        this.left = left;
        list[0] = left;
    }
    public Node getLeft(){
        return left;
    }
    public void setRight(Node right)
    {
        this.right = right;
        list[1] = right;
    }
    public Node getRight()
    {
        return right;
    }
    public boolean hasLeft(){
        if(left != null)
        {
            return true;
        }
        return false;

    }
    public boolean hasRight()
    {
        if(right != null)
        {
            return true;
        }
        return false;
    }
    public Node[] getList(){ return list; }

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
