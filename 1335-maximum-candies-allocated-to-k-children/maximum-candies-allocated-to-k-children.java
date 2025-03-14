class Solution {
    static boolean isOk(int[] can, int mid,long k){
        for(int i: can){
            k-=(long)i/mid;
        }
        if(k>0l)
        return false;
        return true;
    }
    public int maximumCandies(int[] can, long k) {
        int maxi=0;
        for(int i: can){
            maxi=Math.max(maxi,i);
        }
        int low=1, high=maxi,ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(isOk(can,mid,k)){
                low=mid+1;
                ans=mid;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}