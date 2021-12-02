import java.util.*;
import java.util.LinkedList;

class Solution {

    public static int longestkSubstr(String s, int k) {
        // code here
        int count=0;
        int i=0, j=0;
        int res=-1;
        Map<Character,Integer> map = new HashMap();
        while(j<s.length()) {
            char c = s.charAt(j);
            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c,1);
            if(map.size()==k) {
                count=Math.max(res,(j-i+1));
            }
            else if(map.size()>k) {
                while(map.size()>k) {
                    char c1=s.charAt(i);
                    if(map.get(c1)==1) map.remove(c1);
                    else map.put(c1, map.get(c1)-1);
                    i++;
                }
            }
            j++;
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(longestkSubstr("aabacbebebe", 3));
        String s = "abcde";
        System.out.println(s);
        String st = s.substring(1,3);
        System.out.println(st);
    }
}