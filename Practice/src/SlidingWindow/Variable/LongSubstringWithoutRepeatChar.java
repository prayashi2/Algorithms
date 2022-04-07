package SlidingWindow.Variable;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LongSubstringWithoutRepeatChar {

    PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a, b) -> a.getKey()-b.getKey());
    PriorityQueue <Map.Entry<Integer, Integer>> l = new PriorityQueue <> ((a,b)->Integer.compare(a.getKey(),b.getKey()));

    public static int lengthOfLongestSubstring(String s) {
        int i=0, j=0, max=0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while(j<s.length()) {
            char c = s.charAt(j);
            map.compute(c, (key, val) -> val==null ? 1 : val+1);
            if(map.size()<j-i+1) {
                while(map.size()<j-i+1) {
                    char c1 = s.charAt(i);
                    map.put(c1, map.get(c1)-1);
                    if(map.get(c1)==0) map.remove(c1);
                    i++;
                }
            }
            else if(map.size()==j-i+1) {
                max=Math.max(max, j-i+1);
            }
            j++;
        }
        return max;
    }

    public static int lengthOfLongestSubstringShort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0, j=0, max=0;
        while(j<s.length()) {
            char c = s.charAt(j);
            if(map.containsKey(c)) {
                i = Math.max(i, map.get(c)+1);
            }
            map.put(c, j);
            max=Math.max(max, j-i+1);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringShort("abcabcbb"));
    }
}
