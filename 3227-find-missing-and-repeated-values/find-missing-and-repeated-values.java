class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] a = new int[n*n];
        for(int []i: grid){
            for(int j: i){
                a[j-1]++;
            }
        }
        int[] b = new int[2];
        for(int i=0; i<n*n; i++){
            if(a[i]==0){
                b[1]=i+1;
            }
            if(a[i]==2)
                b[0]=i+1;
        }
        return b;
    }
}