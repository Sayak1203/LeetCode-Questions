class Solution {
    public int candy(int[] a) {
        int n = a.length;
        int[] c = new int[n];
        c[0]=1;
        int[] d = new int[n];
        d[n-1]=1;
        int sum=0;
        for(int i=1; i<n; i++){
            if(a[i]>a[i-1]){
                c[i]=c[i-1]+1;
            }else if(a[i]<a[i-1])
                c[i]=1;
            else
                c[i]=1;
        }
        for(int i=n-2; i>=0; i--){
            if(a[i]>a[i+1]){
                d[i]=d[i+1]+1;
            }else if(a[i]<a[i+1])
                d[i]=1;
            else
                d[i]=1;
        }
        for(int i=0; i<n; i++){
            sum+=Math.max(c[i], d[i]);
        }
        return sum;

    }
}