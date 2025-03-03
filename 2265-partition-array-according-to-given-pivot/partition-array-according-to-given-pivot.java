class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, pivot);
        int i=0;
        for(int j: nums){
            if(j<pivot){
                ans[i]=j;
                i++;
            }
        }
        i=n-1;
        for(int j= n-1; j>=0; j--){
            if(nums[j]>pivot){
                ans[i]=nums[j];
                i--;
            }
        }
        return ans;
    }
}