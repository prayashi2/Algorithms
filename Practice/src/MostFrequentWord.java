import java.util.LinkedHashMap;
import java.util.Map;

public class MostFrequentWord {

    public static void main(String args[]) {
        String arr[] = new String[] {"xejdcj", "xejdcj", "lvjpb", "tmyuiu", "lvjpb", "tmyuiu", "ovoba", "lvjpb", "lvjpb", "fqhyu", "fqhyu", "tmyuiu", "xejdcj", "tmyuiu", "fqhyu", "ovoba", "xejdcj"};
        System.out.println(mostFrequentWord(arr, 5));
    }

    public static String mostFrequentWord(String arr[],int n)
    {
        // code here
        Map<String, Integer> map = new LinkedHashMap();
        int maxVal=0;
        String maxStr="";
        for(String s : arr) {
            map.compute(s, (key, val) -> (val==null)?1:val+1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue()>maxVal) {
                maxVal=entry.getValue();
                maxStr=entry.getKey();
            }
        }
        return maxStr;
    }
}
