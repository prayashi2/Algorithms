package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTImplAndTraversal {

    Node root;

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    public void insert(Node temp, int key) {
        Node newNode = new Node(key);
        if(temp==null) {
            root = newNode;
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);
        while(!q.isEmpty()) {
            temp = q.remove();
            if(temp.left==null) {
                temp.left = newNode;
                return;
            }
            else {
                q.add(temp.left);
            }
            if(temp.right==null) {
                temp.right = newNode;
                return;
            }
            else {
                q.add(temp.right);
            }
        }
    }

    public void preOrderRec(Node root) {
        if(root==null) return;
        System.out.print(root.key + " ");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    public void inOrderRec(Node root) {
        if(root==null) return;
        inOrderRec(root.left);
        System.out.print(root.key + " ");
        inOrderRec(root.right);
    }

    public void postOrderRec(Node root) {
        if(root==null) return;
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(root.key + " ");
    }

    public void preOrder(Node root) {
        if(root==null) return;
        Stack<Node> st = new Stack();
        st.push(root);
        while(!st.isEmpty()) {
            Node pop = st.pop();
            System.out.print(pop.key + " ");
            if(pop.right!=null) {
                st.push(pop.right);
            }
            if(pop.left!=null) {
                st.push(pop.left);
            }
        }
    }

    public void inOrder(Node root) {
        if(root==null) return;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(!st.isEmpty() || curr!=null) {
            while(curr!=null) {
                st.push(curr);
                curr=curr.left;
            }
            curr = st.pop();
            System.out.print(curr.key + " ");
            curr=curr.right;
        }
    }

    public void postOrder(Node root) {
        if(root==null) return;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(true) {
            while(curr != null) {
                st.push(curr);
                st.push(curr);
                curr = curr.left;
            }

            // Check for empty stack
            if(st.empty()) return;
            curr = st.pop();

            if(!st.empty() && st.peek() == curr) curr = curr.right;

            else {
                System.out.print(curr.key + " ");
                curr = null;
            }
        }
    }


    public static void main(String[] args) {
        BTImplAndTraversal bt = new BTImplAndTraversal();
        bt.root = new Node(10);
        bt.root.left=new Node(11);
        bt.root.right=new Node(9);
        bt.root.left.left=new Node(7);
        bt.root.right.left=new Node(15);
        bt.root.right.right=new Node(8);
        System.out.println("InOrder Traversal Before");
        bt.inOrder(bt.root);
        System.out.println("");
        bt.insert(bt.root, 12);
        System.out.println("InOrder Traversal After");
        bt.inOrder(bt.root);
        System.out.println("");
        System.out.println("PreOrder Traversal After");
        bt.preOrder(bt.root);
        System.out.println("");
        System.out.println("PostOrder Traversal After");
        bt.postOrder(bt.root);
        System.out.println("");

    }
}
