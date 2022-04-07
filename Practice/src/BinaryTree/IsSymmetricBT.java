package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetricBT {

    public boolean isSymmetricRec(Node root) {
        return isSym(root.left,root.right);
    }

    public boolean isSym(Node x, Node y) {
        if(x== null && y==null) return true;
        if((x!=null && y!=null) && (x.key==y.key)) {
            return isSym(x.left, y.right) && isSym(x.right, y.left);
        }
        return false;
    }

    public boolean isSymmetric(Node root) {
        if(root==null) return true;
        Queue<Node> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()) {
            Node lnode = q.poll();
            Node rnode = q.poll();
            if(lnode==null && rnode==null) continue;
            if(lnode!=null && rnode==null || lnode==null && rnode!=null) return false;
            if(lnode.key!=rnode.key) return false;
            q.add(lnode.left);
            q.add(rnode.right);
            q.add(lnode.right);
            q.add(rnode.left);
        }
        return true;
    }
}
