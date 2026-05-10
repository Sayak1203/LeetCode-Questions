class Solution {
    public static boolean matching(char[] s, char[] p, int i, int j, int n, int m, int[][] dp){
        if(i>=n && j>=m) return true;
        else if(j>=m) return false;
        
        if(i<n && dp[i][j]!=-1) return dp[i][j]==0?false:true;
        boolean match=false;
        if(i<n && (s[i]==p[j] || p[j]=='.')){
            match=true;
        }
        if(j+1<m && p[j+1]=='*'){
            boolean b=(match && matching(s, p, i+1, j, n, m, dp));
            b|=matching(s, p, i, j+2, n, m, dp);
            if(i<n)
            dp[i][j] = b?1:0;
            // System.out.println(b);
            return b;
        }else {
            if(match){
                boolean b = matching(s, p, i+1, j+1, n, m, dp);
                dp[i][j]=b?1:0;
                return b;
            }else {
                if(i<n)
                dp[i][j]=0;
                return false;
            }
        }
    }
    public boolean isMatch(String S, String P) {
        int n = S.length();
        int m = P.length();
        char[] s = S.toCharArray();
        char[] p = P.toCharArray();
        int [][] dp = new int [n][m];
        Arrays.stream(dp).forEach(a-> Arrays.fill(a,-1));
        return matching(s, p, 0, 0, n, m, dp);
        // if(p[0]=='.' || p[0]=='*' | s[0]==p[0]) dp[0][0]=true;
        // for(int i=1; i<n; i++){
        //     if(p[0]=='*') dp[i][0]=true;
        // }
        // for(int i=1; i<m; i++){
        //     if(s[0]==p[i] || p[i]=='.' || p[i]=='*') dp[0][i]=true;
        // }
        // for(int i=1; i<n; i++){
        //     for(int j=1; j<m; j++){
        //         if(s[i]==p[j] || p[j]=='.') dp[i][j]=dp[i-1][j-1];
        //         else if(p[j]=='*'){
        //             dp[i][j]=dp[i-1][j-1]
        //         }
        //         else dp[i][j]=false;
        //     }
        // }
        // return dp[n-1][m-1];
    }
}