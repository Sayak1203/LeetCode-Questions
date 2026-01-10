class Solution {
    static int ans;
    public static int solve(String s, String t, int i, int j, int[][] dp){
        if(i==s.length() || j==t.length()){
            int cur=0;
            for(int k=i; k<s.length(); k++){
                cur+=(int)s.charAt(k);
            }
            for(int k=j; k<t.length(); k++){
                cur+=(int)t.charAt(k);
            }
            // System.out.println(cur);
            dp[i][j]=cur;
            return cur;
        }
        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==t.charAt(j)){
            dp[i][j]= solve(s,t, i+1, j+1, dp);
            return dp[i][j];
        }
        else{
            int a1=solve(s, t, i+1, j, dp)+(int)s.charAt(i);
            int a2=solve(s, t, i, j+1, dp)+(int)t.charAt(j);
            dp[i][j]= Math.min(a1, a2);
            return dp[i][j];
        }
    }
    public int minimumDeleteSum(String s1, String s2) {
        ans=Integer.MAX_VALUE;
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a, -1));
        ans=solve(s1, s2, 0, 0, dp);
        return ans;
    }
}