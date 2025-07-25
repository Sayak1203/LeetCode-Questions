class Solution {
    static ArrayList[] adj(int[][] e, int n){
        ArrayList[] ans = new ArrayList[n];
        for(int i=0; i<n; i++){
            ans[i]=new ArrayList<Integer>();
        }
        for(int[] i: e){
            int u=i[0];
            int v=i[1];
            ans[u].add(v);
            ans[v].add(u);
        }
        return ans;
    }
    static HashMap<Integer, Integer> map;
    static int[] intime;
    static int[] outtime;
    static int t;
    static int dfs(int[] a, int[][] e, int cur, ArrayList[] ad, int par){
        int xr=a[cur];
        t+=1;
        intime[cur]=t;
        for(int i: (ArrayList<Integer>)ad[cur]){
            if(i!=par){
                xr^=dfs(a, e, i, ad, cur);
            }
        }
        t+=1;
        outtime[cur]=t;
        map.put(cur,xr);
        // System.out.println(cur+" "+xr);
        return xr;
    }
    public int minimumScore(int[] ar, int[][] e) {
        int n = ar.length;
        map = new HashMap<>();
        intime = new int[n];
        outtime = new int[n];
        t=0;
        ArrayList[] ad = adj(e, n);
        int leaf=-1;
        for(int i=0; i<n; i++){
            if(ad[i].size()==1){
                leaf=i;
                break;
            }
        }
        int tot = dfs(ar, e, leaf, ad, -1);
        // System.out.println(leaf);
        // System.out.println(Arrays.toString(intime));
        // System.out.println(Arrays.toString(outtime));
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(i!= leaf && j!=leaf){
                    int a = map.get(i);
                    int b=map.get(j);
                    int c = tot;
                    if(intime[i]<intime[j] && outtime[i]>outtime[j]){
                        c^=a;
                        a^=b;
                    }
                    else if(intime[i]>intime[j] && outtime[i]<outtime[j]){
                        c^=b;
                        b^=a;
                    }else{
                        c^=a;
                        c^=b;
                    }
                    int max = Math.max(Math.max(a,b),c);
                    int min = Math.min(Math.min(a,b),c);
                    
        // System.out.println(i+" "+j+" "+a+" "+b+" "+c);
                    ans=Math.min(ans, max-min);
                }
            }
        }
        return ans;

    }
}