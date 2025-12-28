class Solution {
    public boolean canJump(int[] a) {
        int max=a[0];
        int n = a.length;
        int i=0;
        while(i<=Math.min(max, n-1)){
            max=Math.max(max, i+a[i]);
            if(i<max)
            i++;
            else break;
        }
        return i>=n-1;
    }
}