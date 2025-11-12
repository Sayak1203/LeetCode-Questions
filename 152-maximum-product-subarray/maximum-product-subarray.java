class Solution {
    public int maxProduct(int[] a) {
        int n = a.length;
        int ans=a[0];
        for(int i=0; i<n; i++){
            ans=Math.max(ans, a[i]);
        }
        for(int i=0; i<n-1; i++){
            int[] prev = new int[n];
            prev[i]=a[i];
            for(int j=i+1; j<n; j++){
                prev[j]=prev[j-1]*a[j];
                ans=Math.max(ans, prev[j]);
            }
        }
        return ans;
    }
}