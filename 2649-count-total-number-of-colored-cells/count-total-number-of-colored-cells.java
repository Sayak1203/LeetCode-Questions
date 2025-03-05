class Solution {
    public long coloredCells(int n) {
        long ans=1;
        long curr=0;
        for(int i=0; i<n; i++){
            ans+=curr;
            curr+=4;
        }
        return ans;
    }
}