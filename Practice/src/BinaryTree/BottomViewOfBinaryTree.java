package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

    class Tuple {
        Node node;
        int row;

        Tuple(Node node, int row) {
            this.node = node;
            this.row = row;
        }
    }

    //Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root)
    {
        // Code here
        ArrayList <Integer> res = new ArrayList <Integer>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0));
        while(!q.isEmpty()) {
            Tuple pop = q.poll();
            Node node = pop.node;
            int x = pop.row;
            map.compute(x, (k,v) -> v=node.key);
            if(node.left!=null) {
                q.add(new Tuple(node.left, x-1));
            }
            if(node.right!=null) {
                q.add(new Tuple(node.right, x+1));
            }
        }
        map.forEach((k,v) -> res.add(v));
        return res;
    }
}
