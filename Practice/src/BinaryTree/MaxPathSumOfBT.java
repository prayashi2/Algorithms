package BinaryTree;

public class MaxPathSumOfBT {

    public int maxPathSum(Node root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);
        return max[0];
    }

    public int maxPathSum(Node root, int max[]) {
        if(root==null) return 0;
        int lh = Math.max(0, maxPathSum(root.left, max));
        int rh = Math.max(0, maxPathSum(root.right, max));
        max[0] = Math.max(max[0], root.key+lh+rh);
        return root.key + Math.max(lh,rh);
    }
}
