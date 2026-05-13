class Solution {
    static int getDis(int[] a, int []b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
    public int minCostConnectPoints(int[][] p) {
        int n = p.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        PriorityQueue<int[]> pq= new PriorityQueue<>((pl,q)->pl[2]-q[2]);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int w= getDis(p[i], p[j]);
                adj.get(i).add(new int[]{j, w});
                adj.get(j).add(new int[]{i, w});
            }
        }
        boolean[] vis = new boolean[n];
        pq.offer(new int[]{-1, 0, 0});
        Arrays.fill(vis, false);
        // vis[0]=true;
        int cost=0;
        while(!pq.isEmpty()){
            int[] tem = pq.poll();
            int u = tem[1];
            if(vis[u]) continue;
            vis[u]=true;
            cost+=tem[2];
            for(int[] i: adj.get(u)){
                pq.offer(new int[]{u, i[0], i[1]});
            }
        }
        // System.out.println
        return cost;
    }
}