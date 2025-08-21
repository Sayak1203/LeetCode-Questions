class Solution {
    public int numSubmat(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][][] dp = new int[m][n][2];
        dp[0][0][0]=a[0][0];
        dp[0][0][1]=a[0][0];
            int cur=a[0][0];
        for(int i=1; i<n; i++){
            if(a[0][i]==1) cur++; else cur=0;
            dp[0][i][1]=cur;

            if(a[0][i]==1)
            dp[0][i][0]=1;
        }
            cur=a[0][0];
        for(int i=1; i<m; i++){
            if(a[i][0]==1) cur++; else cur=0;
            dp[i][0][0]+=cur;
            if(a[i][0]==1)
            dp[i][0][1]=1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(a[i][j]!=0){
                    dp[i][j][0]=dp[i-1][j][0]+1;
                    dp[i][j][1]=dp[i][j-1][1]+1;
                }
            }
        }
        int tot=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int p = dp[i][j][0], q = dp[i][j][1];
                int tm= q;
                for(int k=i; k>=0; k--){
                    tm=Math.min(tm, dp[k][j][1]);
                    tot+=tm;
                }
                // System.out.print(dp[i][j][0]+","+dp[i][j][1]+" ");
                // System.out.print(tot+" ");
            }
                // System.out.println();
                
        }
        return tot;
    }
}