package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//PreOrder Traversal but right and left interchanged
public class RightViewOfBinaryTree {

    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> rightSideViewRec(Node root) {
        rightSideView(root, 0);
        return res;
    }

    public void rightSideView(Node root, int level) {
        if(root==null) return;
        if(res.size()==level) {
            res.add(root.key);
        }
        rightSideView(root.right, level+1);
        rightSideView(root.left, level+1);
    }

    List<Integer> res1 = new ArrayList<Integer>();
    public List<Integer> rightSideView(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null) return res1;
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0; i<n; i++) {
                Node pop = q.poll();
                if(i==0) {
                    res1.add(pop.key);
                }
                if(pop.right!=null) {
                    q.add(pop.right);
                }
                if(pop.left!=null) {
                    q.add(pop.left);
                }
            }
        }
        return res1;
    }
}
