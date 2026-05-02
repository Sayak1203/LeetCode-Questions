class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Arrays.stream(vis).forEach(a-> Arrays.fill(a, false));
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int ans= 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && grid[i][j]==1){
                    int cnt=0;
                    boolean flag = false;
                    if(i==0 || i==m-1 || j==0 || j==n-1) flag=true;
                    vis[i][j]=true;
                    cnt++;
                    q.add(new Pair<>(i, j));
                    while(!q.isEmpty()){
                        int[] idx = new int[]{-1, 0, 1, 0, -1};
                        Pair p = q.poll();
                        int i1 = (int)p.getKey();
                        int j1 = (int)p.getValue();
                        // System.out.println(i1+" "+j1);
                        if(i1==0 || i1==m-1 || j1==0 || j1==n-1) flag=true;
                        for(int l=0; l<4; l++){
                            int dx = i1+idx[l];
                            int dy = j1+idx[l+1];
                            if(Math.min(dx, dy)<0 || dx>=m || dy>=n){
                                continue;
                            }
                            if(grid[dx][dy]==0 || vis[dx][dy]) continue;
                            else {
                                vis[dx][dy]=true;
                                q.add(new Pair<>(dx, dy));
                                cnt++;
                            }
                        }
                    }
                    if(!flag) ans  += cnt;
                }
            }
        }
        return ans;
    }
}