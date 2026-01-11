class Solution {
    static int solve(int[] a, boolean buy, int tran, int i, int cur, int[][][] dp){
        // System.out.print(i+"-("+cur+") ");
        if(i==a.length) return 0;
        int buyIdx=(buy?0:1);
        if(dp[i][tran][buyIdx]!=-1) return dp[i][tran][buyIdx];
        if(buy && tran>0){
            int notTake = solve(a, buy, tran, i+1, cur, dp);
            int take = -a[i]+solve(a, !buy, tran-1, i+1, cur, dp);
            dp[i][tran][buyIdx]= Math.max(take, notTake);
            return dp[i][tran][buyIdx];
        }else if(!buy){
            int notTake = solve(a, buy, tran, i+1, cur, dp);
            int take = a[i]+solve(a, !buy, tran, i+1, cur, dp);
            dp[i][tran][buyIdx]= Math.max(take, notTake);
            return dp[i][tran][buyIdx];
        }else{
            dp[i][tran][buyIdx]= cur;
            return dp[i][tran][buyIdx];
        }
    }
    public int maxProfit(int[] a) {
        int n = a.length;
        int[][][] dp= new int[n][3][2];
        for(int[][] i: dp){
            for(int[] j: i){
                Arrays.fill(j,-1);
            }
        }
        int ans = solve(a, true, 2, 0, 0, dp);
        // for(int[][] il: dp){
        //     for(int[] j: il){
        //         System.out.print(Arrays.toString(j)+" ");
        //     }
        //     System.out.println();
        // }
        return ans;
    }
}