package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

    class Tuple {
        Node node;
        int row;

        Tuple(Node node, int row) {
            this.node = node;
            this.row = row;
        }
    }

    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    public ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0));
        while(!q.isEmpty()) {
            Tuple pop = q.poll();
            Node node = pop.node;
            int x = pop.row;
            map.computeIfAbsent(x, k -> node.key);
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
