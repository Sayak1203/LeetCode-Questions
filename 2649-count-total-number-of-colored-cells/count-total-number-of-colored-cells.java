class Solution {
    public long coloredCells(int n) {
        long ans=1;
        long curr=0;
        // for(int i=0; i<n; i++){
        //     ans+=curr;
        //     curr+=4;
        // }
        curr=((long)n*(n-1))/2;
        return ans+(long)4*curr;
    }
}