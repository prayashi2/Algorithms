import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class sol {
    static int MissingNumber(int array[], int n) {
        // Your Code Here
        int x1=array[0];
        int x2=1;
        for(int i=1; i<n; i++) {
            x1=x1^array[i];
        }
        for(int i=2; i<=n; i++) {
            x2=x2^i;
        }
        return x1^x2;
    }

    public static void main(String args[]) {
        System.out.println(MissingNumber(new int[]{1,2,3,5}, 5));
    }
}