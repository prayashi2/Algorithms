public class Pattern {

    static int n =5;
    public static void main(String[] args) {
        patternInvPyramidAlt();
    }

    public static void pattern1() {
        //print L
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern2() {
        //print |-
        for(int i=1; i<=n; i++) {
            for(int j=n; j>=i; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern3() {
        //print |_
        //      |-
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for(int i=1; i<=n; i++) {
            for(int j=n-1; j>=i; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern4() {
        //print _|
        for (int i = 1; i <= n; i++) {
            for (int j = n-1; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
        }
    }

    public static void pattern5() {
        //print -|
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j<=i; j++) {
                System.out.print(" ");
            }
            for (int k = n; k>=i; k--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern6() {
        //print _|
        //      -|
        for (int i = 1; i <= n; i++) {
            for (int j = n-1; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j<=i; j++) {
                System.out.print(" ");
            }
            for (int k = n-1; k>=i; k--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern7() {
        //print _| with space
        for(int i=1; i<=n; i++) {
            for(int j=n; j>=i; j--) {
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    public static void pattern7Alt() {
        //print _| with space
        for(int i=1; i<=n; i++) {
            for(int j=n; j>=1; j--) {
                if(j>i) System.out.print(" ");
                else System.out.print(" *");
            }
            System.out.println("");
        }
    }

    public static void patternPyramid() {
        //print |-
        for(int i=1; i<=n; i++) {
            for(int j=n; j>=i; j--) {
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++) {
                System.out.print("*");
            }
            for(int l=2; l<=i; l++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void patternPyramidAlt() {
        //print |-
        for(int i=1; i<=n; i++) {
            for(int j=n; j>=i; j--) {
                System.out.print(" ");
            }
            for(int k=1; k<(i*2); k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void patternInvPyramid() {
        //print -|
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j<=i; j++) {
                System.out.print(" ");
            }
            for (int k = n; k>=i; k--) {
                System.out.print("*");
            }
            for (int l = n-1; l>=i; l--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void patternInvPyramidAlt() {
        //print -|
        for (int i = 5; i >= 1; i--) {
            for (int j = 5; j>i; j--) {
                System.out.print(" ");
            }
            for (int k=1; k<(i*2); k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void patternInvPyramidAlt2() {
        //print -|
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j<=i; j++) {
                System.out.print(" ");
            }
            for (int k=9; k>(i*2); k--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
