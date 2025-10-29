class Solution {
    public int singleNonDuplicate(int[] a) {
        int n = a.length;
        if(n==1)
        return a[0];
        int low = 0, high = n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid==0){
                if(a[mid]!=a[mid+1]) return a[mid];
            }
            else if(mid==n-1){
                if(a[mid]!=a[mid-1]) return a[mid];
            }else{
                if(a[mid]!=a[mid+1] && a[mid]!=a[mid-1]) return a[mid];
                else if((mid%2==0 && a[mid]==a[mid+1]) || (mid%2==1 && a[mid]==a[mid-1])) low=mid+1;
                else high=mid-1;
            }
        }
        return -1;
    }
}