class Solution {
    public static void put(ArrayList<HashMap<Integer, Double>> adj, int p, int q, double val){
        adj.get(p).put(q, val);
        adj.get(q).put(p, 1d/val);
    }
    static double ans;
    public static boolean dfs(ArrayList<HashMap<Integer, Double>> adj, int src, int des, boolean[] vis, double cur){
        if(src==100 || adj.get(src).size()==0 || des==100)
        return false;
        if(src==des){
            ans=cur;
            return true;
        }
        System.out.println(src+" "+des);
            vis[src]=true;
        boolean got=false;
        for(Map.Entry<Integer, Double> ele: adj.get(src).entrySet()){
            if(vis[ele.getKey()]==true){
                continue;
            }
            got|=dfs(adj, ele.getKey(), des, vis, cur*ele.getValue());
            if(got){
                break;
            }
        }
            vis[src]=false;
        return got;
    }
    public double[] calcEquation(List<List<String>> eq, double[] val, List<List<String>> que) {

        ArrayList<HashMap<Integer, Double>> adj = new ArrayList<>();
        for(int i=0; i<26; i++){
            HashMap<Integer, Double> tem = new HashMap<>();
            adj.add(tem);
        }
        int i=0;
        int node=0;
        HashMap<String, Integer> map = new HashMap<>();
        for(List<String> l: eq ){
            String a = l.get(0);
            String b = l.get(1);
            if(map.get(a)==null){
                map.put(a, node);
                node++;
            }
            if(map.get(b)==null){
                map.put(b, node);
                node++;
            }
            int p = map.get(a);
            int q = map.get(b);
            put(adj, p, q, val[i]);
            i++;
        }
        
        double[] answer = new double[que.size()];
        Arrays.fill(answer, -1.0d);
        i=0;
        for(List<String> l: que ){
            String a = l.get(0);
            String b = l.get(1);
            
            int p = map.getOrDefault(a, 100);
            int q = map.getOrDefault(b, 100);
            ans=1d;
            boolean bo = false;
            bo|=dfs(adj, p, q, new boolean[node+1], 1d);
            if(bo){
                answer[i]=ans;
            }
            i++;

        }
        

    return answer;


        // i=0;
        // for(HashMap<Integer, Double> hm: adj){
        //     System.out.println(i);
        //     for(Map.Entry<Integer, Double> ele: hm.entrySet()){
        //         System.out.println(ele.getKey()+" "+ele.getValue());
        //     }
        //     i++;
        // }
        // return new double[]{1d};


    }
}