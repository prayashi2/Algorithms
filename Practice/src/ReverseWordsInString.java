public class ReverseWordsInString {

    static String reverseWords(String S)
    {
        // code here
        String res="";
        String str[]=S.split("\\.");
        for(int i=str.length-1; i>=0; i--) {
            res+=str[i]+".";
        }
        return res.substring(0, res.length()-1);
    }

    public static void main(String args[]) {
        String s="i.like.this.program.very.much";
        System.out.println(reverseWords(s));
    }
}
