class Solution {
    static int solve(int[] a, boolean buy, int tran, int i, int[][][] dp){
        // System.out.print(i+"-(+") ");
        if(i==a.length) return 0;
        if(tran<0){
            return 0;
        }
        int buyIdx=(buy?0:1);
        if(dp[i][tran][buyIdx]!=-1) return dp[i][tran][buyIdx];
        if(buy){
            int notTake = solve(a, buy, tran, i+1, dp);
            int take = -a[i]+solve(a, !buy, tran, i+1, dp);
            dp[i][tran][buyIdx]= Math.max(take, notTake);
            return dp[i][tran][buyIdx];
        }else{
            int notTake = solve(a, buy, tran, i+1, dp);
            int take = a[i]+solve(a, !buy, tran-1, i+1, dp);
            dp[i][tran][buyIdx]= Math.max(take, notTake);
            return dp[i][tran][buyIdx];
        }
    }
    public int maxProfit(int[] a) {
        int n = a.length;
        int[][][] dp= new int[n][2][2];
        for(int[][] i: dp){
            for(int[] j: i){
                Arrays.fill(j,-1);
            }
        }
        int ans = solve(a, true, 1, 0, dp);
        // for(int[][] il: dp){
        //     for(int[] j: il){
        //         System.out.print(Arrays.toString(j)+" ");
        //     }
        //     System.out.println();
        // }
        return ans;
    }
}