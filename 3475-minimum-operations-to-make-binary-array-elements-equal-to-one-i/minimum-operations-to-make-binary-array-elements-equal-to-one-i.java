class Solution {
    public int minOperations(int[] a) {
        int n = a.length;
        int i=0;
        int ans=0;
        while(i<n-2){
            if(a[i]==0){
                a[i]=1-a[i];
                a[i+1]=1-a[i+1];
                a[i+2]=1-a[i+2];
                ans++;
            }
            i++;
        }
        if(a[n-2]==0 || a[n-1]==0)
        return -1;
        else return ans;
    }
}