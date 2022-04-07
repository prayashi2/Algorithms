import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Optional.empty;

public class prayTest2 {

    static String xyz=null;
    private  static  Optional<String> sender = empty();
    //private static Optional<String> sender = Optional.empty();
    public static void main(String[] args) {
        String str="abc";
        //String str = abc == null || abc.length() == 0 ? sender.orElse(def): abc;
        if(sender.isPresent()) {
            str =sender.get();
        }
        System.out.println(str);

        //String htmlContent = "<html><body>Hi, This <secure>hhfhlhl+hfRR</secure>is me. <secure>YDq73YaSxtxmG56dfyvvvv8888YDq73YaSxtxmG56dfyvvvv8888YDq73YaSxtxmG56dfyvvvv8888YDq73YaSxtxmG56dfyvvvv8888YDq73YaSxtxmG56dfyvvvv8888</secure><secure>hhfhlhlhf</secure>";
        String htmlContent = "<html><body>Hi, This <secure>hhfhlhlhfRR</secure>is me. <secure>YDq73YaSxtxmG56d+t5NH22Obc9AxsZbQaOASbPntGqXj6BYopBwFsh0feXx2n+QuvuUWCwDTYaYF1c2rs56Fv9lssiN7ukw750zJXRS7KRwHWECIzP55EP8ejKASi40tmnDQrpmDbMOx/tf0Q9/Gjs+lrtLJBiC4RKlAYwH8MfVuSL7KBzB5xebP6VjkwwprI/30PW2/9804MY6CZf3fFF0TTPebs6MkYsD2gSSPjExYPUKtamshoCw14ywb1eB4WMuHTaTPK0GxxPJKuPCLwGiJRiNxBLDRhMZNhkDzQiwNrDrfdFAR1tQqb4eim3dXLLZrXQuy/beU9y9OPr/oa6ApPc1tNqVG9AJbtUmaTtXv3gYSg5G0n4OoffEju4QvICQ2mcxU0C2fzrJD1KmXhyWh2U+rDMEqAw3nV3hL+x240VLj3yZzy5elPtV/8O5YNuHe1eWw3Q9Cv1u9ny5Kk8/nMJGyrfDFO3Xg32PJ8VpNBQ0GYx4C2Bg6+TsBUoKdBlFutY7KlWuYO4yMBvB/BekaBKx5Genmsvh8/0ta2grntmaQYNv3g/vrN4A1w+F6lgKwJaR9lMQF/i1WfhfI8IDdYsVuhQaS/pMRC+D2QLmA4t8013vNW4jy+0zuvkHfsLSrMSElCRqJlcEs8ZafTtAba8v1cTYjZ4nnb3Qb9A=</secure><secure>hhfhlhlhf</secure>";

        String str1 = "<secure>hhfhlhl\\+hfRR</secure>";

        String decryptHtmlContent = htmlContent.replaceAll(str1, "RRRRRRR");
        System.out.println("replced :"+decryptHtmlContent);
    }
}
