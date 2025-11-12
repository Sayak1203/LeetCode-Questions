class Solution {
    public int lengthOfLIS(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        
        // for(int i=0; i<n; i++){
        //     dp[i][i]=1;
        //     dp[0][i]=1;
        //     if(i>0 && a[i]>a[0]){
        //         dp[0][i]=2;
        //     }
        // }
        for(int i=0; i<n; i++)
        dp[i]=1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){                
                if(a[i]>a[j]){
                    dp[i]=Math.max(dp[i], 1+dp[j]);                    
                }
            }
        }
        int ans=0;
            for(int j: dp){
                ans=Math.max(ans, j);
            }
            // System.out.println(Arrays.toString(dp));
        return ans;
    }
}