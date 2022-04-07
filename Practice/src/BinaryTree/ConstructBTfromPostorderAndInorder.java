package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTfromPostorderAndInorder {

    public Node buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        Node root = buildTree(inorder, 0, inorder.length-1,
                postorder, 0, postorder.length-1, inMap);
        return root;
    }

    public Node buildTree(int[] inorder, int inStart, int inEnd, int[] postorder,
                              int postStart, int postEnd, Map<Integer, Integer> inMap)
    {
        if(inStart>inEnd || postStart>postEnd) return null;

        Node root = new Node(postorder[postEnd]);
        int inRoot = inMap.get(root.key);
        int numsLeft = inRoot-inStart;
        root.left = buildTree(inorder, inStart, inRoot-1,
                postorder, postStart, postStart+numsLeft-1, inMap);
        root.right = buildTree(inorder, inRoot+1, inEnd,
                postorder, postStart+numsLeft, postEnd-1, inMap);
        return root;

    }
}
