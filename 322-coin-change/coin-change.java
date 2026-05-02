class Solution {
    public int coinChange(int[] c, int a) {
        if(a==0) return 0;
        int[] dp = new int[a+1];
        Arrays.sort(c);
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=1; i<=a; i++){
            for(int j=0; j<c.length && c[j]<=i; j++){
                if(c[j]==i) dp[i]=1;
                else if(dp[i-c[j]]<Integer.MAX_VALUE) dp[i]=Math.min(dp[i], 1+dp[i-c[j]]);
            }
        }
        if(dp[a]==Integer.MAX_VALUE) return -1;
        return dp[a];
    }
}