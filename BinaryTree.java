import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {

    static Node root;

    static class Node {
        int data;
        Node left,right;

        Node(int d) {
            data=d;
            left=right=null;
        }
    }

    public static void main(String args[]) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        System.out.println("Inorder Traversal");
        inorder(root);
        insert(root,6);
        insert(root,7);
        insert(root,8);
        System.out.println("");
        System.out.println("Preorder Traversal");
        preorder(root);
        System.out.println("");
        System.out.println("Postorder Traversal");
        postorder(root);
        System.out.println("");
        System.out.println("Inorder Traversal");
        inorder(root);
        delete(root, 7);

    }

    public static void inorder(Node root) {
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if(root==null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root) {
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void insert(Node root, int data) {
        if(root==null) {
            root = new Node(data);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node newNode = new Node(data);
        while(!q.isEmpty()) {
            root=q.poll();
            if(root.left==null) {
                root.left = newNode;
                break;
            }
            else q.add(root.left);

            if(root.right==null) {
                root.right = newNode;
                break;
            }
            else q.add(root.right);
        }
    }

    public static void delete(Node root, int data) {
        if(root == null) return;
        if(root.left==null && root.right==null) {
            if(root.data==data) root=null;
            return;
        }
        Queue<Node> q = new LinkedList();
        q.add(root);
        Node temp=null, keyNode=null;
        while (!q.isEmpty()) {
            temp = q.poll();
            if(temp.data==data) keyNode=temp;
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
        }
        if(keyNode!=null) {
            int x=temp.data;
            deleteDeepest(root,temp);
            keyNode.data=x;

        }
    }

    public static void deleteDeepest(Node root, Node del) {
        Queue<Node> q = new LinkedList();
        q.add(root);
        Node temp=null;
        while (!q.isEmpty()) {
            temp = q.poll();
            if(temp==del) {
                temp=null;
                return;
            }
            if(temp.left!=null) {
                if(temp.left==del) {
                    temp.left=null;
                    return;
                }
                q.add(temp.left);
            }
            if(temp.right!=null) {
                if(temp.right==del) {
                    temp.right=null;
                    return;
                }
                q.add(temp.right);
            }
        }
    }
}
