class Solution {
    
    public int minDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int j=0; j<n; j++){
            dp[m][j]=n-j;
        }
        for(int j=0; j<m; j++){
            dp[j][n]=m-j;
        }
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i][j]=dp[i+1][j+1];
                }else{
                    dp[i][j]=1+Math.min(dp[i+1][j], Math.min(dp[i+1][j+1], dp[i][j+1]));
                }
            }
        }
        return dp[0][0];
    }
}