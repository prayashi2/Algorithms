package SlidingWindow.Variable;

import java.util.HashMap;
import java.util.Map;

public class LongKUniqueCharSubstring {

    public static int longestkSubstr(String s, int k) {
        // code here
        int i=0, j=0, max=-1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while(j<s.length()) {
            char c = s.charAt(j);
            map.compute(c, (key, val) -> val==null ? 1 : val+1);
            if(map.size()==k) {
                max=Math.max(max, j-i+1);
            }
            else if(map.size()>k) {
                while(map.size()>k) {
                    char c1 = s.charAt(i);
                    map.put(c1, map.get(c1)-1);
                    if(map.get(c1)==0) map.remove(c1);
                    i++;
                }
            }
            j++;
        }
        return max;
    }

    public static int longestkSubstrShort(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0, j=0, max=0;
        while(j<s.length()) {
            char c = s.charAt(j);
            if(map.size()>k) {
                i = Math.max(i, map.get(c)+1);
            }
            map.put(c, j);
            max=Math.max(max, j-i+1);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestkSubstr("aabacbebebe", 3));
    }
}
