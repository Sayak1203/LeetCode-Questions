class Solution {
    public int uniquePaths(int m, int n) {
        
        if( m==1 || n==1) return 1;
        m--;
        n--;
        int N = n+m;
        double ans=1;
        for(int i=1; i<=m; i++){
            ans=ans*(N-m+i)/i;
        }
        
        return (int)ans;
    }
}