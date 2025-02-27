class Solution {
    static int maxi;
    static HashMap<Integer, Integer> map;
    static void solve(int[] arr, int idx, int n, int[] curr, int tot){
        // System.out.println(tot);
        if(idx==n){
            return;
        }
            if(map.containsKey(curr[0]+curr[1])){
                int[] temp = new int[2];
                temp[0]=curr[1];
                temp[1]=curr[0]+curr[1];
                maxi=Math.max(maxi, tot+1);
                solve(arr, map.get(curr[0]+curr[1]), n, temp, tot+1);
            }
    }
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        maxi=0;
        map=new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            map.put(arr[i], i);
        }
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int curr[] = new int[2];
                curr[0]=arr[i];
                curr[1]=arr[j];
                solve(arr, j, n, curr, 2);
            }
        }
        return maxi;

    }
}