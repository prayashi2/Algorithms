import java.util.ArrayList;
import java.util.Collections;

public class LeadersInAnArray {

    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> res = new ArrayList();
        int max=arr[n-1];
        res.add(max);
        for(int i=n-2; i>=0; i--) {
            if(arr[i]>=max) {
                max=arr[i];
                res.add(max);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
