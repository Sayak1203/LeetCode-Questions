class Solution {
    static int ans;
    public static void dp(int i, int j, int m, int n, int[][] grid){
        if(i==m-1 && j==n-1){
            ans++;
            return;
        }
        if(i<m-1 && grid[i+1][j]!=1){
            dp(i+1, j, m, n, grid);
        }
        if(j<n-1 && grid[i][j+1]!=1){
            dp(i, j+1, m, n, grid);
        }
        // System.out.print(Arrays.toString(new int[]{i,j})+" ");
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        ans=0;
        int m = grid.length;
        int n = grid[0].length;
        if(grid[m-1][n-1]==1 || grid[0][0]==1) return 0;

        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,0));
        dp[m-1][n-1]=1;
        for(int i=m-2; i>=0; i--){
            if(grid[i][n-1]==1){
                dp[i][n-1]=0;
            }else{
                dp[i][n-1]=dp[i+1][n-1];
            }
        }
        for(int i=n-2; i>=0; i--){
            if(grid[m-1][i]==1){
                dp[m-1][i]=0;
            }else{
                dp[m-1][i]=dp[m-1][i+1];
            }
        }
        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                if(grid[i][j]==0){
                    dp[i][j]=dp[i][j+1]+dp[i+1][j];
                }
            }
        }
        return dp[0][0];
        // dp(0, 0, m, n, grid);
        // return ans;
    }
}