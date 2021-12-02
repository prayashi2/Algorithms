//Add Binary String and return the sum which is also a binary string

import java.lang.reflect.Array;
import java.util.*;
import java.util.Stack;

public class BinarySum {

    public static void main (String args[]) {

        String a = "100";
        String b = "11";

        //String res =sum(a,b);
        //String res=sum1(a,b);
        //System.out.println(res);
        int nums[] = new int[]{2,2,4,4,5,5};
       // int result = removeDuplicates(nums);
        //System.out.println(result);
       // System.out.println(result[1]);
        //lengthOfLongestSubstring("dvdf");
        //char[] chArray= new char[] {'h','e','l','l','o'};
        //reverseString(chArray);
        //boolean res = isPalindrome("A man, a plan, a canal: Panama");
        //System.out.println(res);
       // boolean res = isValidBracket("{}{}{");
        //System.out.println(res);
        //boolean res = visAnagram("anagram","nagaram");
        //System.out.println(res);
        //int res = lengthOfLastWord("    ");
        //System.out.println(res);
        //int res = firstUniqChar("leetcode");
        //System.out.println(res);
        //System.out.println(defangIPaddr("255.100.50.0"));
        //System.out.println(restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
        //System.out.println(longestCommonPrefix( new String[] {"flower","flow","flight"}));
        //System.out.println(titleToNumber("AB"));
        //System.out.println(strStr("a", "a"));
        //System.out.println(largestNumber(new int[] {3,30,34,5,9}));
        System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String s : strs) {
            char[] ch1 = s.toCharArray();
            Arrays.sort(ch1);
            String key = String.valueOf(ch1);
            map.computeIfAbsent(key, k-> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());

    }

    public static String largestNumber(int[] nums) {
        String[] s = Arrays.stream(nums).mapToObj(String::valueOf)
                .toArray(String[]::new);
        String res = "";
        Arrays.sort(s);
        for(int i=s.length-1; i>=0; i--) {
            res+=s[i];
        }
        return res;
    }

    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start<end) {
            nums[start]=nums[start]^nums[end];
            nums[end]=nums[start]^nums[end];
            nums[start]=nums[start]^nums[end];
            start++;
            end--;
        }
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length()<=0) return 0;
        for(int i=0; i<=haystack.length()-needle.length(); i++) {
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return  -1;
    }

    public static int titleToNumber(String columnTitle) {
        int result = 0;
        int n =columnTitle.length()-1;
        for(int i = 0; i<=n; i++) {
            int value = columnTitle.charAt(i) - 'A' +1;
            result = result + (value*(int)Math.pow(26,n-i));
        }
        return result;
    }

    public List<String> fizzBuzz(int n) {
        List result = new ArrayList();
        for(int i=1; i<=n ; i++) {
            if(i%3 == 0 && i%5 == 0) result.add("FizzBuzz");
            else if(i%3 == 0) result.add("Fizz");
            else if(i%5 == 0) result.add("Buzz");
            else result.add(Integer.toString(i));
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++) {
            while (strs[i].indexOf(prefix)!=0) {
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }

    public static String vlongestCommonPrefix(String[] strs) {
        String first = strs[0];
        int last = first.length()-1;
        for(int i=0; i<strs.length; i++) {
            if(strs[i].length()<=0) return "";
            int j =0;
            while(j<strs[i].length() && j<=last) {
                if(strs[i].charAt(j)!=first.charAt(j)) last = j-1;
                else if(j==strs[i].length()-1) last=j;
                j++;
            }
        }
        return first.substring(0, last+1);
    }



    public static String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0 ; i<indices.length; i++) {
            sb.setCharAt(indices[i],s.charAt(i));
        }
        return sb.toString();
    }

    public int numJewelsInStones(String jewels, String stones) {
        Map map = new HashMap();
        int result=0;
        for(char ch : stones.toCharArray()) {
            if(map.containsKey(ch)) map.put(ch, (int)map.get(ch)+1);
            else map.put(ch,1);
        }
        for(char ch : jewels.toCharArray()) {
            if(map.containsKey(ch)) result=result + (int)map.get(ch);
        }
        return result;
    }

    public static String defangIPaddr(String address) {
        String res = address.replaceAll("\\.","[.]");
        return res;
    }

    public static int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(char ch : s.toCharArray()) arr[ch-'a']++;
        for(char ch : s.toCharArray()) {
            if(arr[ch-'a']==1) return s.indexOf(ch);
        }
        return -1;
    }

    public static int lengthOfLastWord(String s) {
        HashMap map = new HashMap();
        int count=0;
        for(int i=0; i<s.length();i++) {
            if(s.charAt(i)==' ' && i!=s.length()-1) {
                map.put(++count,i);
            }
        }
        if (map.isEmpty()) return s.length();
        else return s.length()-1-(int)map.get(count);

    }

    public static boolean visAnagram(String s, String t) {
        int[] a1= new int[91];
        int[] a2= new int[91];
        for(char ch : s.toLowerCase().toCharArray()) {
            a1[ch]++;
        }
        for(char ch : t.toLowerCase().toCharArray()) {
            a2[ch]++;
        }
        int i=0;
        while(i<a1.length) {
            if (a1[i]!=a2[i]) return false;
            i++;
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1,ch2);
    }

    public static boolean isValidBracket(String s) {
        HashMap map = new HashMap();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Stack stack = new Stack();
        for(char ch : s.toCharArray()) {
            if(map.containsKey(ch)) stack.push(ch);
            else if (stack.isEmpty() || (char) map.get(stack.pop())!=ch) return false;
        }
        return stack.empty();

    }

    public static void reverseString(char[] s) {
        int n=s.length-1;
        for(int i=0; i<=n/2;i++) {
            char temp;
            int lastIndex= n-i;
            temp=s[i];
            s[i]=s[lastIndex];
            s[lastIndex]=temp;
        }
        System.out.println(s);
    }

    public static int removeDuplicates(int[] nums) {

        int i=0;
        for(int j=1;j<nums.length;j++) {
            if(nums[i]==nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }

    public static int lengthOfLongestSubstring(String s) {

        int max=0;
        int i=0;
        while(i<s.length()) {
            List list = new ArrayList<>();
            for(int j=i;j<s.length();j++) {
                char ch = s.charAt(j);
                if(!list.contains(ch)) {
                    list.add(ch);
                    if(max<list.size()) {
                        max=list.size();
                    }
                }
                else{
                    break;
                }
            }
            i++;
        }
        return max;


       /* for(char ch : s.toCharArray()) {
            if(!list.contains(ch)) {
                list.add(ch);
                if(max<list.size()) {
                    max=list.size();
                }
            }
            else {
                if(max<list.size()) {
                    max=list.size();
                }
                list.clear();
                list.add(ch);
            }
        }
        return max;*/


    }

    public static String sum (String a, String b) {
        int b1 = Integer.parseInt(a, 2);
        int b2 = Integer.parseInt(b, 2);
        int sum = b1 + b2;
        return Integer.toBinaryString(sum);


    }

    public static String sum1 (String a, String b) {

        String result = "";

        // Initialize digit sum
        int s = 0;

        // Traverse both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result = (char)(s % 2 + '0') + result;

            // Compute carry
            s /= 2;

            // Move to next digits
            i--; j--;
        }

        return result;
    }






}
