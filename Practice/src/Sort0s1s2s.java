public class Sort0s1s2s {

    public static void main(String args[]) {
        int a[] = new int[]{0,1,2,0,1,2};
        int n=6;
        for(int i=0; i<n; i++) {
            System.out.print(a[i]);
        }
        sort012(a, n);
        System.out.println();
        for(int i=0; i<n; i++) {
            System.out.print(a[i]);
        }
    }

    public static void sort012(int a[], int n)
    {
        // code here
        int l=0, m=0, h=n-1;
        int temp;
        while(m<=h) {
            if(a[m]==0) {
                temp=a[l];
                a[l]=a[m];
                a[m]=temp;
                l++;
                m++;
            }
            else if(a[m]==1) {
                m++;
            }
            else if(a[m]==2) {
                temp=a[h];
                a[h]=a[m];
                a[m]=temp;
                h--;
            }
        }
    }
}
