class Solution {
    public int largestRectangleArea(int[] a) {
        Stack<Integer> st = new Stack<>();
        int n = a.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }
            else{
                pse[i]=st.peek();
            }
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
            else{
                nse[i]=st.peek();
            }
            st.push(i);
        }
        // System.out.println(Arrays.toString(pse));
        // System.out.println(Arrays.toString(nse));
        int ans=0;
        for(int i=0; i<n; i++){
            ans=Math.max(ans, a[i]*(nse[i]-pse[i]-1));
        }
        return ans;
    }
}