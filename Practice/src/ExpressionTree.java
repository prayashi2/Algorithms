import java.util.Stack;

public class ExpressionTree {

    public static void postorder(ETNode root) {
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }

    public static void inorder(ETNode root) {
        if(root==null) return;
        if(isOperator(root.data)) System.out.print("(");
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
        if(isOperator(root.data)) System.out.print(")");
    }

    public static boolean isOperator(char op) {
        return (op =='+' || op =='-' || op =='*' || op =='/' || op =='^');
    }

    public static ETNode constructTree(String postfix) {

        Stack<ETNode> s = new Stack();
        for(char c : postfix.toCharArray()) {
            if(isOperator(c)) {
                ETNode r = s.pop();
                ETNode l = s.pop();
                s.add(new ETNode(c,l,r));
            }
            else s.add(new ETNode(c));
        }
        return s.pop();
    }

    public static void main(String args[]) {
        //String postfix="ab+ef*g*-";
        String postfix="ab+cde+**";
        ETNode root = constructTree(postfix);
        System.out.println("Post Order Traversal");
        postorder(root);
        System.out.println("");
        System.out.println("In Order Traversal");
        inorder(root);
        /*String prefix="*+ab-cd";
        onstructPrefixTree(prefix);
        String infix = "";
        constructInfixTree(infix);*/
    }

    public static ETNode constructPrefixTree(String prefix) {
       return null;
    }

    public static ETNode constructInfixTree(String infix) {
        Stack<ETNode> s = new Stack();
        for(char c : infix.toCharArray()) {
            if(c=='(') continue;
            else if(c==')') {
                ETNode r = s.pop();
                ETNode op = s.pop();
                ETNode l = s.pop();
                s.add(new ETNode(op.data,l,r));
            }
            else s.push(new ETNode(c));
        }
        return s.pop();
    }
}


class ETNode {

    char data;
    ETNode left, right;

    ETNode(char data) {
        this.data = data;
        this.left=this.right=null;
    }

    ETNode(char data, ETNode left, ETNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    String val;
    ETNode(String data) {
        this.val = data;
        this.left=this.right=null;
    }
}