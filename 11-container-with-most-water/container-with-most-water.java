class Solution {
    public int maxArea(int[] a) {
        int n = a.length;
        int i=0, j=n-1;
        int max=0;
        while(i<j){
            int cur = Math.min(a[j], a[i])*(j-i);
            max=Math.max(max, cur);
            if(a[i]<a[j]){
                i++;
            }else j--;
        }
        return max;
    }
}