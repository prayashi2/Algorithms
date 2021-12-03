import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {

    static Node root;

    static class Node
    {
        int data;
        Node left, right;
        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static void printLevelOrder() {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
        }
    }

    static void printLevelOrderRecursion() {
        int h = height(root);
        for(int i=1; i<=h; i++) {
            printCurrentRootLevel(root,i);
        }
    }

    static int height(Node root) {
        if(root == null) return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        if(lheight>rheight) return (lheight+1);
        else return (rheight+1);
    }

    static void printCurrentRootLevel(Node root, int level) {
        if(root == null) return;
        if(level == 1) System.out.print(root.data + " ");
        else if(level>1) {
            printCurrentRootLevel(root.left, level-1);
            printCurrentRootLevel(root.right, level-1);
        }
    }

    static void inorder(Node root) {
        Stack<Node> s = new Stack();
        Node curr = root;
        while(!s.isEmpty() || curr!=null) {
            if(curr!=null) {
                s.push(curr);
                curr=curr.left;
            }
            else {
                curr=s.pop();
                System.out.print(curr.data + " ");
                curr=curr.right;
            }
        }
    }

    static void preorder(Node root) {
        Stack<Node> s = new Stack();
        Node curr = root;
        while (!s.empty() || curr!=null) {
            if(curr!=null) {
                s.push(curr);
                System.out.print(curr.data + " ");
                curr=curr.left;
            }
            else {
                curr=s.pop();
                curr=curr.right;
            }
        }
    }

    static void postorder(Node root) {
        Stack<Node> s = new Stack();
        s.push(root);
        Stack<Integer> out = new Stack();
        while(!s.isEmpty()) {
            Node curr = s.pop();
            out.push(curr.data);
            if(curr.left!=null) s.push(curr.left);
            if(curr.right!=null) s.push(curr.right);
        }
        while (!out.isEmpty()) {
            System.out.print(out.pop() + " ");
        }
    }

    public static void main(String args[]) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        printLevelOrder();
        System.out.println("");
        printLevelOrderRecursion();
        System.out.println("");
        System.out.println("Inorder Traversal");
        inorder(root);
        System.out.println("");
        System.out.println("Preorder Traversal");
        preorder(root);
        System.out.println("");
        System.out.println("Preorder Traversal");
        postorder(root);
    }
}


