class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> set=new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        
        int cnt=0; 
        int max=1;
        for(int i: set){
            cnt=1;
            if(!set.contains(i-1)){
                int cur=i+1;
                while(set.contains(cur)){
                    cnt++;
                    cur++;
                }
                max=Math.max(max, cnt);
            }
        }
        return max;
    }
}