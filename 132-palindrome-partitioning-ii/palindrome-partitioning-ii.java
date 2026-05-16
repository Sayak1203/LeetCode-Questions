class Solution {
    public boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;

            i++;
            j--;
        }
        return true;
    }
    public int solve(String s, int i, int n, int[] dp){
        if(i==n){
            return 0;
        }
        if(dp[i]!=Integer.MAX_VALUE) return dp[i];
        for(int j=i; j<n; j++){
            if(s.charAt(i)==s.charAt(j) && isPalindrome(s, i, j)){
                dp[i]=Math.min(dp[i], 1+solve(s, j+1, n, dp));
            }
        }
        return dp[i];
    }
    public int minCut(String s) {
        int n = s.length();
        // boolean[][] pal = new boolean[n][n];
        // Arrays.stream(dp).forEach(a-> Arrays.fill(a, false));
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return solve(s, 0, n, dp)-1;
    }
}