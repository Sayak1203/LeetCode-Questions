class Solution {
    public static boolean solve(String s, String t, int i, int j){
        if(i==s.length() && j==t.length()) return true;
        else if(i==s.length() && (j<t.length() && t.charAt(j)=='*')) return solve(s,t,i,j+1);
        else if(i==s.length() || j==t.length()) return false;

        if(s.charAt(i)==t.charAt(j) || t.charAt(j)=='?'){
            return solve(s, t, i+1, j+1);
        }
        else if(t.charAt(j)=='*'){
            return solve(s, t, i+1, j)|solve(s, t, i, j+1);
        }
        else return false;
    }
    public boolean isMatch(String s, String t) {
        // return solve(s,p,0,0);
        int n = s.length(), m = t.length();
        boolean[][] dp = new boolean[n+1][m+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,false));
        dp[n][m]=true;
        int k=m-1;
        while(k>=0 && t.charAt(k)=='*'){
            dp[n][k]=true;
            k--;
        }
        // for(boolean[] i: dp){
        //     System.out.println(Arrays.toString(i));
        // }
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(s.charAt(i)==t.charAt(j) || t.charAt(j)=='?'){
                    dp[i][j]|=dp[i+1][j+1];
                }
                else if(t.charAt(j)=='*'){
                    dp[i][j]|=dp[i+1][j]|dp[i][j+1];
                }

            }
        }
        return dp[0][0];
    }
}