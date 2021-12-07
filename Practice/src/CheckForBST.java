public class CheckForBST {

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

    boolean isBST(Node root)
    {
        // code here.
        return isBSTUtil(root, null, null);
    }

    boolean isBSTUtil(Node node, Node l, Node r) {
        if(node==null) return true;
        if(l!=null && node.data<=l.data) return false;
        if(r!=null && node.data>=r.data) return false;
        return (isBSTUtil(node.left, l, node) && isBSTUtil(node.right, node, r));
    }
}
