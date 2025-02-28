class Solution {
    static String ans;
    static void LCS(String s1, String s2, int i, int j, StringBuilder st){
        // if(i==s1.length() || j==s2.length()){
        //     if(ans.length()<st.length()){
        //         ans=st.toString();
        //     }
        //     return;
        // }
        // if(s1.charAt(i)==s2.charAt(j)){
        //     st.append(s1.charAt(i));
        //     LCS(s1, s2, i+1, j+1, st);
        //     st.setLength(st.length()-1);
        // }
        // else{
        //     LCS(s1, s2, i, j+1, st);
        //     LCS(s1, s2, i+1, j, st);
        // }
    }
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length(), m=s2.length();
        int[][] dp = new int[n+1][m+1];
        // for(int i=0; i<n; i++){
        //     if(s1.charAt(i)==s2.charAt(0)){
        //         dp[i][0]=1;
        //     }
        // }
        // for(int i=0; i<m; i++){
        //     if(s1.charAt(0)==s2.charAt(i)){
        //         dp[0][i]=1;
        //     }
        // }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        StringBuilder st = new StringBuilder();
        int i = n, j=m;
        while(i>0 && j>0){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    st.append(s1.charAt(i-1));
                    j--;
                    i--;
                }
                else if(dp[i-1][j]>dp[i][j-1]){                    
                    st.append(s1.charAt(i-1));
                    i--;
                }
                else{                    
                    st.append(s2.charAt(j-1));
                    j--;
                }
        }
        while(i>0){
            st.append(s1.charAt(i-1));
            i--;
        }
        while(j>0){
            st.append(s2.charAt(j-1));
            j--;
        }
        // for(int[] ar: dp){
        //     System.out.println(Arrays.toString(ar));
        // }
 
        return st.reverse().toString();
    }
}