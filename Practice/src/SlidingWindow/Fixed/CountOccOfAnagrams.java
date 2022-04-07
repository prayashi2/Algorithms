package SlidingWindow.Fixed;

import java.util.HashMap;
import java.util.Map;

public class CountOccOfAnagrams {

    public static int search(String pat, String txt) {
        // code here
        int i=0, j=0, res=0;
        int K = pat.length();
        int N = txt.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : pat.toCharArray()) {
            map.compute(c, (key, val) -> (val==null) ? 1 : val+1);
        }
        int count=map.size();
        while(j<N) {
            char c = txt.charAt(j);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) count--;
            }
            if(j-i+1==K) {
                if(count==0) res++;
                char c1 = txt.charAt(i);
                if(map.containsKey(c1)) {
                    map.put(c1, map.get(c1)+1);
                    if(map.get(c1)==1) count++;
                }
                i++;
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(search("for", "forxxorfxdofr"));
    }
}
