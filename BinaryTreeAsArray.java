import java.util.ArrayList;
import java.util.List;

public class BinaryTreeAsArray {
    int root=0;
    static String[] str = new String[15];

    public void setRoot(String key) {
        str[0]=key;
    }

    public void setLeft(String key, int root) {
        int t = (root*2)+1;
        if(str[root]==null) System.out.println("No parent found");
        else str[t]=key;
    }

    public void setRight(String key, int root) {
        int t = (root*2)+2;
        if(str[root]==null) System.out.println("No parent found");
        else str[t]=key;
    }

    public static void print() {
        for(int i=0; i<str.length; i++) {
            if(str[i]!=null) {
                System.out.print(str[i]);
            }
            else {
                System.out.print("-");
            }
        }
    }

    public static void main(String args[]) {
        BinaryTreeAsArray b = new BinaryTreeAsArray();
        b.setRoot("A");
        b.setLeft("B",0);
        b.setRight("C",0);
        b.setLeft("D",2);
        b.setRight("E",1);
        b.setLeft("F",4);
        b.setLeft("G",5);
        print();
    }
}
