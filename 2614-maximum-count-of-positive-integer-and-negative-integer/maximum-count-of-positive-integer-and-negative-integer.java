class Solution {
    public int maximumCount(int[] a) {
        int n = a.length;
        int low=0, high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]<0){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        while(low<n && a[low]==0)
        low++;
        // System.out.println(low+" "+high);
        return Math.max(high+1,n-low);
    }
}