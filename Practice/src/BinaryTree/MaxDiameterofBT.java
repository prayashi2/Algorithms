package BinaryTree;

public class MaxDiameterofBT {

    public int diameterOfBinaryTree(Node root) {
        int max[] = new int[1];
        diameterOfBinaryTree(root, max);
        return max[0];
    }

    public int diameterOfBinaryTree(Node root, int[] max) {
        if(root==null) return 0;
        int lh = diameterOfBinaryTree(root.left, max);
        int rh = diameterOfBinaryTree(root.right, max);
        max[0]=Math.max(max[0], lh+rh);
        return 1+Math.max(lh, rh);
    }
}
