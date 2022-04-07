package SlidingWindow.Fixed;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxofAllSubarrays {

    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        int i=0, j=0;
        LinkedList<Integer> q = new LinkedList();
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(j<n) {
            while(!q.isEmpty() && q.getLast()<arr[j]) q.removeLast();
            q.addLast(arr[j]);
            if(j-i+1==k) {
                res.add(q.getFirst());
                if(q.getFirst()==arr[i]) q.removeFirst();
                i++;
            }
            j++;
        }
        return res;
    }
}
