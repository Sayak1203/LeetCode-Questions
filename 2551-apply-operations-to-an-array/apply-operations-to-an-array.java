class Solution {
    public int[] applyOperations(int[] a) {
        int n = a.length;
        for(int i=0; i<n-1; i++){
            if(a[i]==a[i+1]){
                a[i]*=2;
                a[i+1]=0;
                i++;
            }
        }
        
        int[] ans = new int[n];
        int i=0;
        for(int j: a){
            if(j!=0){
                ans[i]=j;
                i++;
            }
        }
        return ans;

    }
}