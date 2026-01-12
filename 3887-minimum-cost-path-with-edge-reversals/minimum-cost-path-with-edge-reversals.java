class Solution {
    public int minCost(int n, int[][] a) {
        ArrayList<HashMap<Integer, Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new HashMap<>());
        }
        // int[][] g=new int[n][n];
        // Arrays.stream(g).forEach(ah->Arrays.fill(ah, Integer.MAX_VALUE));
        for(int[] k: a){
            int i=k[0], j=k[1], w = k[2];
            adj.get(i).put(j, Math.min(w, adj.get(i).getOrDefault(j, Integer.MAX_VALUE)));
            adj.get(j).put(i, Math.min(2*w, adj.get(j).getOrDefault(i, Integer.MAX_VALUE)));
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((ah,b)->ah[0]-b[0]);
        pq.add(new int[]{0,0});
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int d = top[0];
            int u = top[1];
            if(dis[u]<d){
                continue;
            }
            dis[u]=d;
            // System.out.println(adj);
            for(Map.Entry<Integer, Integer> ele: adj.get(u).entrySet()){
                int i = ele.getKey();
                pq.offer(new int[]{ele.getValue()+d, i});
            }
        }
        return dis[n-1]==Integer.MAX_VALUE?-1:dis[n-1];
    }
}