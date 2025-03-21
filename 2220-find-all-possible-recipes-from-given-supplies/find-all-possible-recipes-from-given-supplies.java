class Solution {
    public List<String> findAllRecipes(String[] r, List<List<String>> ing, String[] s) {
        HashSet<String> set = new HashSet<>();
        int n = r.length;
        for(String x: s){
            set.add(x);
        }
        boolean[] vis = new boolean[n];
        Arrays.fill(vis,false);
        List<String> ans= new ArrayList<>();
        for(int j=0; j<100; j++){
            int flag2=0;
            for(int i=0; i<n; i++){
                if(vis[i]==true)
                continue;
                if(set.contains(r[i])){
                    ans.add(r[i]);
                    vis[i]=true;
                    flag2=1;
                    continue;
                }
                int flag=1;
                // System.out.println(flag);
                for(String x: ing.get(i)){
                    if(!set.contains(x)){
                        flag=0;
                        break;
                    }
                }
                if(flag==1){
                    ans.add(r[i]);
                    set.add(r[i]);
                    vis[i]=true;
                    flag2=1;
                }
            }
            if(flag2==0){
                break;
            }
        }
        return ans;
    }
}