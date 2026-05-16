class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        DSU(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            Arrays.fill(this.rank, 0);
            for(int i=0; i<n; i++){
                this.parent[i]=i;
            }
        }
        public int ulp(int i){
            if(this.parent[i]==i) return i;
            else {
                this.parent[i]=ulp(this.parent[i]);
                return this.parent[i];
            }
        }
        public void edge(int i, int j){
            int a = ulp(i), b=ulp(j);
            if(a==b) return;
            if(this.rank[a]>this.rank[b]){
                this.parent[b]=a;
            }
            else if(this.rank[a]<this.rank[b]){
                this.parent[a]=b;
            }
            else{
                this.parent[a]=b;
                this.rank[b]++;
            }
        }
    }
    public int findCircleNum(int[][] g) {
        int n = g.length;
        DSU d = new DSU(n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(g[i][j]==1){
                    d.edge(i, j);
                }
            }
        }
        for(int i=0; i<n; i++){
            d.parent[i]=d.ulp(i);
        }
        Set<Integer> set = new HashSet<>();
        for (int num : d.parent) {
            set.add(num);
        }
        return set.size();
    }
}