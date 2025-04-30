class Solution {
    public int jump(int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        Arrays.fill(ans, (int)1e9);
        ans[0]=0;
        for(int i=0; i<n; i++){
            int dis = a[i];
            for(int j=i; j<=i+dis && j<n; j++){
                ans[j]=Math.min(ans[j], ans[i]+1);
            }
        }
        // System.out.println(Arrays.toString(ans));
        return ans[n-1];
    }
}