import java.util.ArrayList;
import java.util.List;

public class StringSubset {
    static public List<String> subsetsWithDup(String nums) {
        List<String> res = new ArrayList<String>();
        subset("", nums, res);
        return res;
    }

    static public void subset(String sub, String nums, List<String> res) {
        if(nums.length()==0) {
            res.add(sub);
            return;
        }
        subset(sub, nums.substring(1), res);
        subset(nums.charAt(0)+sub, nums.substring(1), res);
    }

    public static void main(String args[]) {
        System.out.println(subsetsWithDup("abc"));
    }
}
