class Solution {
    static int dp[];
    static boolean ok(int[] dp){
        if(dp[0]==0 || dp[1]==0 || dp[2]==0)
        return false;
        return true;
    }
    static int atLeast(String s){
        int l=0,r=0;
        int n = s.length();
        char[] c = s.toCharArray();
        int ans=0;
        while(r<=n){
            while(r<n && (dp[0]==0 || dp[1]==0 || dp[2]==0)){
                dp[c[r]-'a']++;
                r++;
            }
            if(!(dp[0]==0 || dp[1]==0 || dp[2]==0)){
                ans+=n-r+1;
            }
            if(l==n)
            break;

                dp[c[l]-'a']--;
                l++;
        }
        return ans;
    }
    public int numberOfSubstrings(String s) {
        dp=new int[]{0, 0, 0};
        return atLeast(s);
    }
}