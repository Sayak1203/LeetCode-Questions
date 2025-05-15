class Solution {
    public List<String> getLongestSubsequence(String[] w, int[] g) {
        List<String> list = new ArrayList<String>();
        int n = w.length;
        int c=g[0]==0?1:0;
        for(int i=0; i<n; i++){
            if(g[i]!=c){
                list.add(w[i]);
                c=g[i];
            }
        }
        return list;
    }
}