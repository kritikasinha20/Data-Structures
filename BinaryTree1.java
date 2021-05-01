import java.util.*;
public class BinaryTree1{
    static class Node
    {
        int key;
        Node left,right;
        Node(int key)
        {
            this.key = key;
           left = null;
           right = null;
        }
    }
    static Node root;
    static Node temp = root;
    static void inorder(Node temp)
    {
        if(temp == null)
        {
            return;
        }
        inorder(temp.left);
        System.out.println(temp.key);
        inorder(temp.right);

    }
    static void insert(Node temp,int key)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);
        //follow the method of remove,print and add
        while(!q.isEmpty())
        {
            temp = q.peek();
            q.remove();
            if(temp.left == null)
            {
                temp.left = new Node(key);
                break;
            }
            else{
                q.add(temp.left);
            }
            if(temp.right == null)
            {
                temp.right = new Node(key);
                break;
            }
            else 
               q.add(temp.right);

            
        }
    }
    //function to delete rightmost deepest node
    static void deepestNode(Node root,Node delNode)
    {
        Queue<Node> q1 = new LinkedList<Node>();
        q1.add(root);
        Node temp = null;
        while(!q1.isEmpty())
        {
            temp = q1.peek();
            q1.remove();
            if(temp == delNode)
            {
                temp = null;
                return;
            }
            

        }
    }
   
    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
 
        System.out.print(
            "Inorder traversal before insertion:");
        inorder(root);
 
        int key = 12;
        insert(root, key);
 
        System.out.print(
            "\nInorder traversal after insertion:");
        inorder(root);

        
    }
}