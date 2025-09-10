class Solution {
    public void nextPermutation(int[] a) {
        int n = a.length;
        int i=n-2;
        while(i>=0 && a[i]>=a[i+1]){
            i--;
        }
        int k = i+1;
        int min=Integer.MAX_VALUE;
        int minIdx=i;
        while(k<n && i>=0){
            if(a[k]>a[i] && a[k]<min){
                minIdx=k;
            }
            k++;
        }
        if(i>=0 && minIdx<n){
            int tem=a[i];
            a[i]=a[minIdx];
            a[minIdx]=tem;
        }
            i++;
        
        int j=i;
        int[] ar = new int[n-j];
        for(; j<n; j++){
            ar[j-i]=a[j];
        }
        Arrays.sort(ar);
        
        j=i;
        for(; j<n; j++){
            a[j]=ar[j-i];
        }

    }
}