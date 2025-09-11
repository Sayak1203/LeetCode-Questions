class Solution {
    public int[][] merge(int[][] in) {
        Arrays.sort(in, (a,b)-> a[0]- b[0]);
        Stack<int[]> st = new Stack<>();
        st.push(in[0]);
        int i=1;
        int n = in.length;
        while(i<n){
            if(in[i][0]<=st.peek()[1]){
                int[] j = st.pop();
                j[1]=Math.max(in[i][1], j[1]);
                st.push(j);
            }
            else st.push(in[i]);
            i++;
        }
        int m= st.size();
        int[][] ans = new int[m][2];
        for(i=m-1; i>=0; i--){
            int[] j = st.pop();
            ans[i][0]=j[0];
            ans[i][1]=j[1];
        }
        return ans;
    }
}