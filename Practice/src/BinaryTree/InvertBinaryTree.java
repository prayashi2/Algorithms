package BinaryTree;

public class InvertBinaryTree {

    public Node invertTree(Node root) {
        if(root==null) return root;
        Node temp = root.left;
        root.left = root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
