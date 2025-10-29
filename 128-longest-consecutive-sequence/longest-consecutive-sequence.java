class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> set=new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        ArrayList<Integer> ar = new ArrayList<>(set);
        Collections.sort(ar);
        int cnt=1; 
        int cur=ar.get(0);
        int max=1;
        for(int i=1; i<ar.size(); i++){
            if(ar.get(i)==cur+1){
                cnt++;
            }else{
                cnt=1;
            }
            cur=ar.get(i);
            max=Math.max(max, cnt);
        }
        return max;
    }
}