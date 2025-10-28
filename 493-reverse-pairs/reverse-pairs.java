class Solution {
    static int pair;
    static void merge(int i, int k, int j, int[] a){
        int[] t = new int[j-i+1];
        int p=i, q=k;
        int x=0;
        while(p<k && q<=j){
            while(p<k && (long)a[p]<=(long)2l*a[q]){
                p++;
            }
            if(p>=k) break;
            pair+=k-p;
            // System.out.println(i+" "+j);
            q++;
        }
        p=i;
        q=k;
        while(p<k && q<=j){
            if(a[p]<=a[q]){
                t[x]=a[p];
                p++;
            }else{
                t[x]=a[q];
                q++;
            }
            x++;
        }
        while(p<k){
            t[x]=a[p];
            p++;
            x++;
        }
        while(q<=j){
            t[x]=a[q];
            q++;
            x++;
        }
        for(int l=0; l<x; l++){
            a[i+l]=t[l];
        }
    }
    static void mergeSort(int i, int j, int[] a){
        if(i==j) return;
        int mid = i+(j-i)/2;
        mergeSort(i, mid, a);
        mergeSort(mid+1, j, a);
        merge(i, mid+1, j, a);
    }
    public int reversePairs(int[] a) {
        pair=0;
        int n = a.length;
        mergeSort(0, n-1, a);
        return pair;
    }
}