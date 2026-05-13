class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        int[] a = new int[n];
        Arrays.fill(a, 0);
        a[0]=1;
        a[1]=1;
        for(int i=2; i<n; i++){
            for(int j=i; ((long)i*j)<(long)n; j++){
                a[i*j]=1;
            }
        }
        int cnt=0;
        for(int i: a){
            if(i==0) cnt++;
        }
        return cnt;
    }
}