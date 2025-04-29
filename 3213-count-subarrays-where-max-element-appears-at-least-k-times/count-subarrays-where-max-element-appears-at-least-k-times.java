class Solution {
    public long countSubarrays(int[] a, int k) {
        int n = a.length;
        int max = 0;
        for(int i: a){
            max= Math.max(max, i);
        }
        long tot = (long)n*(n+1)/2l;
        int l=0, r=0, c=0;
        if(a[r]==max)
        c++;
        while(r<n){
            while(c<k && r<n){
                tot-=(long)(r-l+1);
                // System.out.println(r+" "+l+" "+tot);
                r++;
                if(r<n && a[r]==max){
                    c++;
                }
            }
            if(l<n && a[l]==max){
                c--;
            }
            l++;
        }
        return tot;

    }
}