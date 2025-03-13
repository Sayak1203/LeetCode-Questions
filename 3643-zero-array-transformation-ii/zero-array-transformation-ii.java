class Solution {
    static boolean isOk(int[] nums, int[][] que, int mid){
        int cur=0;
        int n = nums.length;
        int[] dp = new int[n+1];
        for(int i=0; i<=mid; i++){
            int l = que[i][0];
            int r = que[i][1];
            int val = que[i][2];
            dp[l]-=val;
            dp[r+1]+=val;
        }
        for(int i=0; i<n; i++){
            cur+=dp[i];
            nums[i]+=cur;
            if(nums[i]>0)
            return false;
        }
            // System.out.println(mid);
        // for(int i[]: dp){
        // }

        return true;
    }
    public int minZeroArray(int[] nums, int[][] que) {
        int n = nums.length;
        int q = que.length;
        int flag=0;
        for(int i: nums){
            if(i>0)
            flag=1;
        }
        if(flag==0)
        return 0;
        int low=0, high=q-1, ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int[] nums2 = nums.clone();
            if(isOk(nums2, que, mid)){
                high=mid-1;
                ans=mid+1;
            }
            else{
                low=mid+1;
            }
        }
        
        return ans;
    }
}