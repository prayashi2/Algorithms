import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    static Node root;

    class Node {
        int data;
        Node left,right;

        Node(int data) {
            this.data=data;
        }
    }

    int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public Node deleteRec(int key, Node root) {
        if(root==null) return root;
        else if(root.data>key) {
            root.left = deleteRec(key, root.left);
        }
        else if(root.data<key) {
            root.right = deleteRec(key, root.right);
        }
        else {
            if(root.left==null) {
                return root.right;
            }
            else if(root.right==null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right=deleteRec(root.data, root.right);
        }
        return root;
    }

    public void delete(int key) {
        root = deleteRec(key, root);
    }

    public Node search(int key, Node root) {
        if(root==null || root.data==key) return root;
        else if(root.data>key) {
            return search(key, root.left);
        }
        else {
            return search(key, root.right);
        }
    }

    public void inorder(Node root) {
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public Node insertRec(int data, Node root) {
        if(root==null) {
            root=new Node(data);
            return root;
        }
        else if(root.data>data) {
            root.left=insertRec(data, root.left);
        }
        else {
            root.right=insertRec(data, root.right);
        }
        return root;
    }

    public void insert (int data) {
        root = insertRec(data, root);
    }

    public static void main(String args[]) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inorder(root);
        System.out.println("");
        Node found = tree.search(90, root);
        if(found!=null) {
            System.out.println("Element is " + found.data);
        }
        else {
            System.out.println("Element is not found");
        }
        tree.delete(20);
        tree.inorder(root);
        System.out.println("");
        tree.delete(30);
        tree.inorder(root);
        System.out.println("");
        tree.delete(50);
        tree.inorder(root);
        System.out.println("");
    }
}
