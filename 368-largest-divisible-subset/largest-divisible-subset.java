class Solution {
    public List<Integer> solve(int[] a, int[] dp, int idx) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(idx!=-1){
            arr.add(a[idx]);
            idx=dp[idx];
        }
        Collections.reverse(arr);
        return arr;
    }
    public List<Integer> largestDivisibleSubset(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(a[i]%a[j]==0){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        dp2[i]=j;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        // System.out.println(Arrays.toString(dp2));
        int maxIdx=0;
        for(int i=0; i<n; i++){
            if(dp[i]>dp[maxIdx]){
                maxIdx=i;
            }
        }
        return solve(a, dp2, maxIdx);

    }
}