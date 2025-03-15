class Solution {
    static boolean isOk(int mid, int[] a, int k){
        int i=0, n=a.length, c=0;
        while(i<n){
            if(a[i]<=mid){
                c++;
                i++;
            }
            i++;
        }
        if(c>=k)
        return true;
        return false;
    }
    public int minCapability(int[] nums, int k) {
        int n = nums.length, maxi=-1;
        for(int i: nums){
            maxi=Math.max(maxi,i);
        }
        int l=0, h=maxi,ans=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(isOk(mid, nums, k)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}