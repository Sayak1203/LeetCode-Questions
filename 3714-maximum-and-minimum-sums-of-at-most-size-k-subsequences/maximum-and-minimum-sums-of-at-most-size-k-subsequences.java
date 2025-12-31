class Solution {
    private static int[][] memo;
    private static final int MOD = 1_000_000_007;
    public static int nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        
        // If we have already calculated this value, return it
        if (memo[n][r] != -1) {
            return memo[n][r];
        }

        // Apply modulo at each addition step
        memo[n][r] = (nCr(n - 1, r - 1) + nCr(n - 1, r)) % MOD;
        return memo[n][r];
    }


    public int minMaxSums(int[] a, int k) {
        Arrays.sort(a);
        int n = a.length;
        long ans=0;
        int mod = (int)1e9+7;
        memo = new int[n + 1][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        for(int i=0; i<n; i++){
            for(int j=1; j<=Math.min(k, n-i); j++){
                long tem=(long)nCr(n-i-1, j-1);
                ans+=((long)(tem*(long)a[i])%mod);
                ans%=mod;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=1; j<=Math.min(k, i+1); j++){
                long tem=(long)nCr(i, j-1);
                ans+=((long)(tem*(long)a[i])%mod);
                ans%=mod;
            }
        }
        return (int)ans;
    }
}