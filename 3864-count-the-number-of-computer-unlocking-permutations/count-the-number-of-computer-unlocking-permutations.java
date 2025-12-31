class Solution {
    public int countPermutations(int[] com) {
        int min=com[0];
        int n = com.length;
        for(int i=1; i<n; i++){
            if(com[i]<=min){
                return 0;
            }
        }
        long ans=1;
        long mod=(long)1e9+7;
        for(int i=n-1; i>=2; i--){
            ans*=(long)i;
            ans%=mod;
        }
        return (int)ans;
    }
}