class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++){
            List<Integer> in = new ArrayList<Integer>();
            //if(i==0)
            in.add(1);
            for(int j=1; j<i; j++){
                in.add(ans.get(i-1).get(j)+ans.get(i-1).get(j-1));
            }
            if(i>0)
            in.add(1);

            ans.add(in);
        }
        return ans;
    }
}