import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterBit {

    public static void main (String args[]) {

        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(isSub("aba"));
        System.out.println(solve("abcDAv"));
    }

    public static int isPalindrome(String A) {
        A = A.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i=0;
        int j=A.length()-1;
        while(i<j) {
            if (A.charAt(i)!=A.charAt(j)) return 0;
            i++;
            j--;
        }
        return 1;
    }

    public static int isSub1(String A) {
        List<Character> vow = Arrays.asList('a','e','i','o','u');
        int count=0;
        for(int i =0 ; i<A.length(); i++) {
            String sub = "";
            for(int j=i ; j<A.length(); j++) {
                sub +=A.charAt(j);
                if(vow.contains(sub.charAt(0)) && !vow.contains(sub.charAt(sub.length()-1))) count++;
                else if(!vow.contains(sub.charAt(0)) && vow.contains(sub.charAt(sub.length()-1))) count++;
            }
        }
        return count;
    }

    public static int isSub(String A) {
        int count = 0;
        List<Character> v = Arrays.asList('a','e','i','o','u');
        List<Integer> vow = new ArrayList();
        List<Integer> con = new ArrayList();
        for(int i =0 ; i<A.length(); i++) {
            if (v.contains(A.charAt(i))) vow.add(i);
            else con.add(i);
        }
        for(int i : vow) {
            for(int j : con) {
                count++;
            }
        }
        return count;
    }

    public static int solve1(String A) {
        List<Character> vow = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        int count = 0;
        for(int i = 0 ; i<A.length() ; i++) {
            String sub = "";
            for(int j =i ; j<A.length() ; j++) {
                sub+=A.charAt(j);
                if(vow.contains(sub.charAt(0))) count++;
            }
        }
        return count%10003;
    }

    public static int solve(String A) {
        char []a = A.toCharArray();
        Character []vowel = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        ArrayList<Character> list = new ArrayList(Arrays.asList(vowel));
        int n=a.length;
        int count=0;

        for(int i=0; i<n; i++) {
            if(list.contains(a[i]) ) {
                count += n-i;
            }

        }
        return (count%10003);
    }
}
