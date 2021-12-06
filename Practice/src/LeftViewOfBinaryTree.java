import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {

    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root==null) return res;
        q.add(root);
        while(!q.isEmpty()) {
            int n=q.size();
            for(int i=1; i<=n; i++) {
                Node temp = q.poll();
                if(i==1) res.add(temp.data);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }
        return res;
    }
}
