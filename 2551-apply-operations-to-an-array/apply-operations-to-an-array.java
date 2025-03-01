class Solution {
    public int[] applyOperations(int[] a) {
        int n = a.length;
        for(int i=0; i<n-1; i++){
            if(a[i]==a[i+1]){
                a[i]*=2;
                a[i+1]=0;
            }
        }
        
        int i=0, j=0;
        while(i<n){
            while(i<n && a[i]!=0){
                i++;
            }
            j=i;
            while(j<n && a[j]==0){
                j++;
            }
            if(i<n && j<n){
                a[i]=a[i]+a[j]-(a[j]=a[i]);
            }
            i++;
        }

        return a;

    }
}