class Solution {
    public int maximumUniqueSubarray(int[] a) {
        HashSet<Integer> set= new HashSet<>();
        int n = a.length;
        int i=0, j=0;
        int ans=a[0];
        int sum=0;
        while(i<n){
            while(i<n && !set.contains(a[i])){
                set.add(a[i]);
                sum+=a[i];
                i++;
                ans = Math.max(ans, sum);
            }
            if(i>=n)
            break;
            while(j<n-1 && a[j]!=a[i]){
                set.remove(a[j]);
                sum-=a[j];
                j++;
            }
                set.remove(a[j]);
                sum-=a[j];
                j++;
        }
        return ans;
    }
}