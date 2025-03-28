class Solution {
    static ArrayList<Pair> solve(Pair<Integer, Integer> p, int n, int m){
        int[] dx = {-1, 0 , 1, 0};
        int[] dy = {0, -1, 0 , 1};
        ArrayList<Pair> ar = new ArrayList<>();
        for(int i=0; i<4; i++){
            int x=p.getKey()+dx[i];
            int y=p.getValue()+dy[i];
            if(x>=0 && x<m && y>=0 && y<n){
                ar.add(new Pair<>(x,y));
            }
        }
        return ar;
    }
    public int[] maxPoints(int[][] grid, int[] q) {
        int qt = q.length;
        int n = grid[0].length;
        int m = grid.length;
        int[][] dp = new int [qt][3];
        for(int i=0; i<qt; i++){
            dp[i][0]=i;
            dp[i][1]=q[i];
            dp[i][2]=0;
        }
        Arrays.sort(dp,(a,b)->(a[1]-b[1]));
        Queue<Pair<Integer,Integer>> q1 = new LinkedList<>();
        Queue<Pair<Integer,Integer>> q2 = new LinkedList<>();
        int cnt=1;
        q1.add(new Pair<>(0,0));
        int i = 0;
        while(i<qt && grid[0][0]>=dp[i][1]){
            i++;
           continue;
        }
        boolean[][] vis = new boolean[m][n];
        Arrays.stream(vis).forEach(a->Arrays.fill(a,false));
        vis[0][0]=true;
        for(; i<qt; i++){
            if(i>0 && dp[i][1]==dp[i-1][1]){
                dp[i][2]=cnt;
                continue;
            }
            Queue<Pair<Integer,Integer>> q3 = new LinkedList<>();
            while(!q2.isEmpty()){
                Pair<Integer, Integer> x=q2.poll();
                int dx=(int)x.getKey();
                int dy=(int)x.getValue();
                if(vis[dx][dy]==false && grid[dx][dy]<dp[i][1]){
                    vis[dx][dy]=true;
                    // System.out.print(dx+","+dy+" ");
                    cnt++;
                    q1.add(x);
                }
                else if(vis[dx][dy]==false){
                    q3.add(x);
                }
            }
            q2=q3;
            q3=new LinkedList<>();
            while(!q1.isEmpty()){
                ArrayList<Pair> p = solve(q1.poll(),n,m);
                for(Pair x: p){
                    int dx=(int)x.getKey();
                    int dy=(int)x.getValue();
                    if(vis[dx][dy]==false && grid[dx][dy]<dp[i][1]){
                        vis[dx][dy]=true;
                        // System.out.print(dx+","+dy+" ");
                        cnt++;
                        q1.add(x);
                    }
                    else if(vis[dx][dy]==false){
                        // System.out.print(dx+"x"+dy+" ");
                        q2.add(x);
                    }
                }
            }
            // q1=q3;
            dp[i][2]=cnt;
            // System.out.println();
        }
        Arrays.sort(dp,(a,b)->a[0]-b[0]);
        int[] ans = new int[qt];
        for(i=0; i<qt; i++){
            ans[i]=dp[i][2];
        }
        return ans;
    }
}