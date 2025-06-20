class Solution {
    static int solve(int n, int s, int e, int w, int k){
        int temp = Math.max(n,s);
        n = Math.min(n,s);
        s= temp;
        temp = Math.max(e,w);
        e = Math.min(e,w);
        w= temp;
        int ans = s+w-n-e;
        ans+=2*Math.min(k, n+e);
        // System.out.println(ans+" "+ n+" "+ s+" "+ e+" "+ w);
        return ans;
    }
    public int maxDistance(String st, int k) {
        int n = 0, s=0, e=0, w=0;
        int ans=0;
        for(char c : st.toCharArray()){
            if(c=='N')
            n++;
            else if(c=='S')
            s++;
            else if(c=='E')
            e++;
            else if(c=='W')
            w++;
            ans=Math.max(ans, solve(n, s, e, w, k));
        }
        return ans;
    }
}