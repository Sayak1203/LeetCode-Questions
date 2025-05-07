class Solution {
    ArrayList<int[]> f(int i, int j, int m, int n, int cur, int[][] mt, int[][] vis){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        ArrayList<int[]> arr = new ArrayList<int[]>();
        for(int k=0; k<4; k++){
            int x = i+dx[k];
            int y = j+dy[k];
            if(x<0 || y<0 || x>=m || y>=n || vis[x][y]!=-1){
                continue;
            }
            vis[x][y]=Math.max(mt[x][y], cur+1);
            arr.add(new int[]{x, y, vis[x][y]});
        }
        return arr;
    }
    public int minTimeToReach(int[][] mt) {
        int m = mt.length;
        int n = mt[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0, 0, Math.min(0, mt[0][0]-1)});
        int [][] vis = new int[m][n];
        Arrays.stream(vis).forEach(a->Arrays.fill(a, -1));
        vis[0][0]=0;
        while(!pq.isEmpty()){
            int[] a = pq.poll();
            ArrayList<int[]> arr = f(a[0], a[1], m, n, a[2], mt, vis);
            for(int[] x: arr){
                pq.offer(x);
            }
        }
        // for(int[] i: vis){
        //     System.out.println(Arrays.toString(i));
        // }
        return vis[m-1][n-1]+1;
    }
}