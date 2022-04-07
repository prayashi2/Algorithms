package String;

import java.util.HashSet;
import java.util.Set;

public class isIsogram {

    static boolean isIsogram(String data){
        //Your code here
        Set s = new HashSet<Character>();
        for(char c : data.toCharArray()) {
            if(s.contains(c)) return false;
            s.add(c);
        }
        return true;
    }
}
