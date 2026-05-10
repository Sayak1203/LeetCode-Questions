class Solution {
    public int maximumJumps(int[] a, int t) {
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1]=0;
        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){
                if(Math.abs(a[i]-a[j])<=t && dp[j]!=-1){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
        }
        return dp[0];
    }
}