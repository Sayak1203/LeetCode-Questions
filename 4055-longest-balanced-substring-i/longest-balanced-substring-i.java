class Solution {
    public static boolean checkBalanced(int[][] a, int i, int j){
        int n = a.length;
        int[] p = new int[26];
        for(int k=0; k<26; k++){
            p[k]=a[j][k]-a[i][k];
        }
        Arrays.sort(p);
        for(int k=0; k<26; k++){
            if(p[k]!=0 && p[k]!=p[25])
            return false;
        }
        return true;
    }
    public int longestBalanced(String S) {
        char[] s =S.toCharArray();
        int n = S.length();
        int[][] a = new int[n+1][26];
        int[] x = new int[26];
        a[0]=x.clone();
        x[s[0]-'a']++;
        a[1]=x.clone();
        for(int i=1; i<n; i++){
            x[s[i]-'a']++;
            a[i+1]=x.clone();
        }
        int ans=1;
        
        for(int i=0; i<=n; i++){
            for(int j=i+ans; j<=n; j++){
                if(checkBalanced(a, i, j)){
                    ans=Math.max(ans, j-i);
                    // System.out.println(ans+" "+i+" "+j);
                }
            }
        }
        return ans;
    }
}