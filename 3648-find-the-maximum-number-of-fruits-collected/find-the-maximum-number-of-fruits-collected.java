class Solution {
    static int up, down;
    static void solveUp(int[][] a, int i, int j, int cur, int left){
        int n = a.length;
        if(i>j || Math.min(i,j)<0 || Math.max(i,j)>=n || left<=0) return;
        if(i==n-1 && j==n-1){
            up=Math.max(up, cur);
        }
        cur+=a[i][j];
        left--;
        int[] dx = new int[]{-1, 0, 0, 1, -1, 1, 1, -1};
        int[] dy = new int[]{0, 1, -1, 0, 1, -1, 1, -1};
            for(int ih=0; ih<8; ih++){
                solveUp(a, i+dx[ih], j+dy[ih], cur, left);
            }
        
    }
    static void solveDown(int[][] a, int i, int j, int cur, int left){
        int n = a.length;
        if(i<j  || Math.min(i,j)<0 || Math.max(i,j)>=n || left<=0) return;
        if(i==n-1 && j==n-1){
            down=Math.max(down, cur);
        }
        cur+=a[i][j];
        left--;
            // System.out.println(cur+"-"+i+","+j+"  ");
            int[] dx = new int[]{-1, 0, 1, 0, -1, 1, 1, -1};
            int[] dy = new int[]{0, 1, 0, -1, 1, -1, 1, -1};
            for(int ih=0; ih<7; ih++){
                solveDown(a, i+dx[ih], j+dy[ih], cur, left);
            }
        
    }
    public int maxCollectedFruits(int[][] a) {
        int n = a.length;
        int f=0;
        int[][] dp= new int[n][n];
        int[][] a2= new int[n][n];
        int[][] dp2= new int[n][n];
        for(int i=0; i<n; i++){
            f+=a[i][i];
            a[i][i]=0;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                a2[i][j]=a[i][j];
                a[i][j]=0;
            }
        }
        // solveUp(a, 0, n-1, 0, n);
        // solveDown(a, n-1, 0, 0, n);
            // System.out.println(f+" "+up+" "+down);
            for(int i=n-2; i>=0; i--){
                for(int j=n-1; j>=n/2; j--){
                    int p = dp[i+1][j], q=0, r=0;                    
                    if(j+1<n)
                    q=dp[i+1][j+1];
                    if(j-1>=0)
                    r=dp[i+1][j-1];
                    dp[i][j]=a[i][j]+Math.max(p, Math.max(q,r));
                }
            }
            for(int i=n-2; i>=0; i--){
                for(int j=n-1; j>=n/2; j--){
                    int p = dp2[j][i+1], q=0, r=0;                    
                    if(j+1<n)
                    q=dp2[j+1][i+1];
                    if(j-1>=0)
                    r=dp2[j-1][i+1];
                    dp2[j][i]=a2[j][i]+Math.max(p, Math.max(q,r));
                }
            }
        up=dp[0][n-1]+dp2[0][n-1]; down=dp[n-1][0]+dp2[n-1][0];
        // for(int []i: dp){
        //     System.out.println(Arrays.toString(i));
        // }
        // for(int []i: dp2){
        //     System.out.println(Arrays.toString(i));
        // }
        return up+f+down;
    }
}