class Solution {
    public int search(int[] a, int tar) {
        int n = a.length;
        int low=0, high=n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(a[mid]==tar) return mid;
            else if(a[mid]<tar){
                if((a[high]<=tar && a[high]<=a[mid]) || (a[high]>=tar && true)) low=mid+1;
                else high=mid-1;
            }
            else{
                if((a[low]<=tar && true) || (a[low]>=tar && a[low]>a[mid])) high=mid-1;
                else 
                low=mid+1;
            }
            System.out.println(mid);
        }
        return -1;
    }
}