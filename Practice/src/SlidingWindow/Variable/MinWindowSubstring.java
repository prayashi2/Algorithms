package SlidingWindow.Variable;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static String minWindow(String s, String t) {
        int i=0, j=0, count=0, min=Integer.MAX_VALUE;
        String res="";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()) {
            map.compute(c, (key, val) -> val==null ? 1 : val+1);
        }
        count=map.size();
        while(j<s.length()) {
            char c1 = s.charAt(j);
            if(map.containsKey(c1)) {
                map.put(c1, map.get(c1)-1);
                if(map.get(c1)==0) count--;
            }
            while(count==0) {
                if(count==0) {
                    if(j-i+1<min) {
                        min=j-i+1;
                        res=s.substring(i,j+1);
                    }
                }
                char c2 = s.charAt(i);
                if(map.containsKey(c2)) {
                    map.put(c2, map.get(c2)+1);
                    if(map.get(c2)==1) count++;
                }
                i++;
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
