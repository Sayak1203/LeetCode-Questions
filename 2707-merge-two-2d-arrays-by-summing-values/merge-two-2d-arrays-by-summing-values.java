class Solution {
    public int[][] mergeArrays(int[][] n1, int[][] n2) {
        int[] a = new int[1001];
        int n = n1.length;
        for(int i=0; i<n; i++){
            a[n1[i][0]]+=n1[i][1];
        }
        for(int i=0; i<n2.length; i++){
            a[n2[i][0]]+=n2[i][1];
        }
        ArrayList<int[]> ar = new ArrayList<>();
        for(int i=0; i<1001; i++){
            if(a[i]!=0){
                int[] t = new int[2];
                t[0]=i;
                t[1]=a[i];
                ar.add(t);
            }
        }
        int[][] ans= new int[ar.size()][2];
        for(int i=0; i<ar.size(); i++){
            ans[i]=ar.get(i);
        }
        return ans;
        
    }
}