public class EvalExpressionTree {

    public static boolean isLeaf(ETNode root) {
        return (root.left==null && root.right==null);
    }

    public static double eval(String op, double x, double y) {
        if (op == "+") { return x + y; }
        if (op == "-") { return x - y; }
        if (op == "×") { return x * y; }
        if (op == "/") { return x / y; }
        return 0;
    }

    public static double evaluate(ETNode root) {
        if(root==null) return 0;
        if(isLeaf(root)) {
            return Integer.valueOf(root.val);
        }
        double x = evaluate(root.left);
        double y = evaluate(root.right);
        return eval(root.val, x, y);
    }

    public static void main(String[] args)
    {
        ETNode root = new ETNode("+");
        root.left = new ETNode("×");
        root.right = new ETNode("/");
        root.left.left = new ETNode("-");
        root.left.right = new ETNode("5");
        root.right.left = new ETNode("21");
        root.right.right = new ETNode("7");
        root.left.left.left = new ETNode("10");
        root.left.left.right = new ETNode("5");
        System.out.println("The value of the expression tree is " + evaluate(root));
    }
}



