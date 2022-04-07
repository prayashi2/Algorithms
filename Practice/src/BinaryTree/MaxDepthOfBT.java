package BinaryTree;

public class MaxDepthOfBT {

    public int maxDepth(Node root) {
        if(root==null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1 + Math.max(lh, rh);
    }
}
