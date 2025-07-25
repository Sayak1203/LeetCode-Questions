class Solution {
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        if(nums[nums.length-1]<0) return nums[nums.length-1];
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int sum=0;
        for(int i: set){
            if(i>0) sum+=i;
        }
        return sum;
    }
}