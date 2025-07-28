class Solution {
    static int solve(int[] a, int or, int i, int maxOr){
        if(i==a.length){
            if(or==maxOr)
            return 1;

            return 0;
        }
        int nt=solve(a, or, i+1, maxOr);
        int t=solve(a, or|a[i], i+1, maxOr);
        return nt+t;
    }
    public int countMaxOrSubsets(int[] nums) {
        int n =nums.length;
        int or = 0;
        for(int i: nums){
            or|=i;
        }
        return solve(nums, 0, 0, or);
    }
}