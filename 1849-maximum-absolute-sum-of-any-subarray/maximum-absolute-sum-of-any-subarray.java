class Solution {
    public int maxAbsoluteSum(int[] a) {
        int n = a.length;
        int ans=0, curr=0;
        for(int i: a){
            curr+=i;
            if(curr<0){
                curr=0;
            }
            ans=Math.max(ans, curr);
        }
        curr=0;
        for(int i: a){
            curr-=i;
            if(curr<0){
                curr=0;
            }
            ans=Math.max(ans, curr);
        }
        return ans;
    }
}