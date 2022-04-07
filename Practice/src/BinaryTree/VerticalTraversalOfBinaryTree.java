package BinaryTree;

import java.util.*;

public class VerticalTraversalOfBinaryTree {

    class Tuple {
        Node node;
        int row;
        int col;
        Tuple(Node node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while(!q.isEmpty()) {
            Tuple pop = q.poll();
            Node node = pop.node;
            int x = pop.row;
            int y = pop.col;

            if(!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).add(node.key);

            if(node.left!=null) {
                q.add(new Tuple(node.left, x-1, y+1));
            }
            if(node.right!=null) {
                q.add(new Tuple(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> inMap : map.values()) {
            List<Integer> inRes = new ArrayList();
            for(PriorityQueue<Integer> nodes : inMap.values()) {
                while (!nodes.isEmpty()) {
                    inRes.add(nodes.poll());
                }
            }
            res.add(inRes);
        }
        return res;
    }

}
