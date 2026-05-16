class Solution {
    public static ArrayList<int[]> border(char[][] g, int m, int n){
        ArrayList<int[]> ar = new ArrayList<>();
        for(int i=0; i<m; i++){
            if(g[i][0]=='O'){
                ar.add(new int[]{i, 0});
            }
            if(g[i][n-1]=='O'){
                ar.add(new int[]{i, n-1});
            }
        }
        for(int i=0; i<n; i++){
            if(g[0][i]=='O'){
                ar.add(new int[]{0, i});
            }
            if(g[m-1][i]=='O'){
                ar.add(new int[]{m-1, i});
            }
        }
        return ar;
    }
    public static void dfs(char[][] dum, char[][] g, boolean[][] vis, int[] a){
        
        int m = g.length;
        int n = g[0].length;
        int i=a[0], j=a[1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j]=true;
        dum[i][j]='O';
        while(!q.isEmpty()){
            int[] x = q.poll();
            int[] d = {-1, 0, 1, 0, -1};
            for(int l=0; l<4; l++){
                int dx = x[0]+d[l];
                int dy = x[1]+d[l+1];
                if(Math.min(dx, dy)<0 || dx>=m || dy>=n || vis[dx][dy]==true || g[dx][dy]=='X'){
                    continue;
                }
                else{
                    vis[dx][dy]=true;
                    dum[dx][dy]='O';
                    q.add(new int[]{dx, dy});
                }
            }
        }
    }
    public void solve(char[][] g) {
        int m = g.length;
        int n = g[0].length;
        char[][] dum = new char[m][n];
        Arrays.stream(dum).forEach(a->Arrays.fill(a, 'X'));
        ArrayList<int[]> ar = border(g, m, n);
        
        boolean[][] vis = new boolean[m][n];
        Arrays.stream(vis).forEach(p->Arrays.fill(p, false));
        for(int[] i: ar){
            if(vis[i[0]][i[1]]) continue;
            dfs(dum, g, vis, i);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                g[i][j]=dum[i][j];
            }
        }
    }
}