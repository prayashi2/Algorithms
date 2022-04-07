package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalOfBinaryTree {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        Queue<Node> q = new LinkedList<>();
        if(root==null) return res;
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                Node poll = q.poll();
                list.add(poll.key);
                if(poll.left!=null) q.add(poll.left);
                if(poll.right!=null) q.add(poll.right);
            }
            res.add(list);
        }
        return res;
    }
}
