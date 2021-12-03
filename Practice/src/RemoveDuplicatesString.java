public class RemoveDuplicatesString {

    String removeDups(String S) {
        // code here
        String res="";
        for(char c : S.toCharArray()) {
            if(res.indexOf(c)<0)  res+=c;
        }
        return res;
    }
}
