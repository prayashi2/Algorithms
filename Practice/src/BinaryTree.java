import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {

    static BinaryTreeNode root;

    static class BinaryTreeNode {
        int data;
        BinaryTreeNode left,right;

        BinaryTreeNode(int d) {
            data=d;
            left=right=null;
        }
    }

    public static void main(String args[]) {
        root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(5);
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

    public static void inorder(BinaryTreeNode root) {
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(BinaryTreeNode root) {
        if(root==null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(BinaryTreeNode root) {
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void insert(BinaryTreeNode root, int data) {
        if(root==null) {
            root = new BinaryTreeNode(data);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(root);
        BinaryTreeNode newNode = new BinaryTreeNode(data);
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

    public static void delete(BinaryTreeNode root, int data) {
        if(root == null) return;
        if(root.left==null && root.right==null) {
            if(root.data==data) root=null;
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList();
        q.add(root);
        BinaryTreeNode temp=null, keyNode=null;
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

    public static void deleteDeepest(BinaryTreeNode root, BinaryTreeNode del) {
        Queue<BinaryTreeNode> q = new LinkedList();
        q.add(root);
        BinaryTreeNode temp=null;
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
