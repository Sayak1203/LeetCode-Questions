class Solution {
    public static boolean solve(int[][] g, int i, int color, int[] col){

        col[i]=color;
        for(int j: g[i]){
            if(col[j]==color) return false;

            if(col[j]==-1 && solve(g, j, 1-color, col)==false) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] g) {
        int n = g.length;
        int[] col = new int[n];
        Arrays.fill(col, -1);
        for(int i=0; i<n; i++){
            if(col[i]==-1){
                if(solve(g, i, 0, col)==false) return false;
            }
        }
        return true;
    }
}