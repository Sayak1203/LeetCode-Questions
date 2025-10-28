class Solution {
    public int[] twoSum(int[] a, int tar) {
        int n = a.length;
        HashMap<Integer, Integer> map =new HashMap<>();
        for(int i=0; i<n; i++){
            if(map.containsKey(tar-a[i])){
                return new int[]{map.get(tar-a[i]), i};
            }
            map.put(a[i], i);
        }
        return new int[]{0, 1};
    }
}