class Solution {
    public int maximumLength(int[] a) {
        int n = a.length;
        int z=0, o=0;
        for(int i=0; i<n; i++){
            a[i]%=2;
            if(a[i]==1) o++; else z++;
        }
        int ans = Math.max(o, z);
        int f = a[0];
        int c=1;
        for(int i=0; i<n; i++){
            if(f!=a[i]){
                f=a[i];
                c++;
            }
        }
        ans = Math.max(ans, c);
        return ans;

    }
}