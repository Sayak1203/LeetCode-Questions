class Solution {
    public static int solve(int[] a){
        int n = a.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }
            else pse[i]=st.peek();
            st.push(i);
        }
        st=new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=n;
            }
            else nse[i]=st.peek();
            st.push(i);
        }
        int ans=0;
        for(int i=0; i<n; i++){
            ans=Math.max(ans, a[i]*(nse[i]-pse[i]-1));
        }
            // System.out.println(Arrays.toString(a));
        return ans;

    }
    public int maximalRectangle(char[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[] histo = new int[m];
        int ans=0;
        int cur=0;
        Arrays.fill(histo, 0);
        for(int i=0; i<m; i++){
            histo[i]=(int)(a[0][i]-'0');
            if(a[0][i]=='1'){
                cur++;
            }
            else cur=0;
                ans=Math.max(ans, cur);
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j]=='0'){
                    histo[j]=0;
                }
                else{
                    histo[j]++;
                }
            }
            int curAns=solve(histo);
            ans=Math.max(ans,curAns);
        }
        return ans;
    }
}