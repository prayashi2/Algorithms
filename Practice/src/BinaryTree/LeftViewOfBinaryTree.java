package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//PreOrder Traversal
public class LeftViewOfBinaryTree {

    ArrayList<Integer> res = new ArrayList<Integer>();
    ArrayList<Integer> leftViewRec(Node root)
    {
        // Your code here
        leftViewUtil(root, 0);
        return res;
    }

    void leftViewUtil(Node root, int level)
    {
        // Your code here
        if(root==null) return;
        if(res.size() == level) {
            res.add(root.key);
        }
        leftViewUtil(root.left, level+1);
        leftViewUtil(root.right, level+1);

    }

    ArrayList<Integer> res1 = new ArrayList<Integer>();
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        if(root==null) return res1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0; i<n; i++) {
                Node pop = q.remove();
                if(i==0) {
                    res1.add(pop.key);
                }
                if(pop.left!=null) {
                    q.add(pop.left);
                }
                if(pop.right!=null) {
                    q.add(pop.right);
                }
            }
        }
        return res1;
    }
}
