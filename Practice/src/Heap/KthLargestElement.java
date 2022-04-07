package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i : nums) {
            pq.add(i);
            if(pq.size()>k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
