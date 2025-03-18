class Solution {
    public int longestNiceSubarray(int[] arr) {
        int mask=0, i=0,j=0;
        int ans=1;
        int n= arr.length;
        while(i<n){
            while(i<n && (mask & arr[i])==0){
                mask=mask|arr[i];
                i++;
            }
            ans=Math.max(ans, i-j);
            mask=mask^arr[j];
            j++;
        }
        return ans;
    }
}