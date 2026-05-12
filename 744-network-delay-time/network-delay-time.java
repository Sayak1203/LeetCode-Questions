class Solution {
    static int[] dijkstra(List<List<int[]>> adj, int k){
        PriorityQueue<int[]> pq= new PriorityQueue<>((p,q)-> p[1]-q[1]);
        int[] dis = new int[adj.size()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k]=0;
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] tem = pq.poll();
            if(tem[1]>dis[tem[0]]){
                continue;
            }
            for(int[] i: adj.get(tem[0])){
                int w = i[1];
                if(dis[tem[0]]+w<dis[i[0]]){
                    dis[i[0]]=dis[tem[0]]+w;
                    pq.offer(new int[]{i[0], dis[i[0]]});
                }
            }
            // System.out.println(Arrays.toString(dis));
        }
        return dis;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i: times){
            int u = i[0];
            int v = i[1];
            int w = i[2];
            adj.get(u).add(new int[]{v, w});
            // adj.get(v).add(new int[]{u, w});
        }
        int[] dis = dijkstra(adj, k);
        int maxTime=0;
        for(int i=1; i<=n; i++){
            maxTime = Math.max(maxTime, dis[i]);
        }
        return maxTime==Integer.MAX_VALUE?-1:maxTime;
    }
}