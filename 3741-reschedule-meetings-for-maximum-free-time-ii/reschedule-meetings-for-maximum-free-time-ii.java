class Solution {
    public int maxFreeTime(int t, int[] s, int[] e) {
        int n = s.length;
        int[] gap = new int[n+1];
        int[] pre = new int[n+1];
        int[] suf = new int[n+1];
        gap[0]=s[0];
        for(int i=1; i<n; i++){
            gap[i]=s[i]-e[i-1];
        }
        gap[n]=t-e[n-1];
        pre[0]=gap[0];
        for(int i=1; i<=n; i++){
            pre[i]=Math.max(gap[i], pre[i-1]);
        }
        suf[n]=gap[n];
        for(int i=n-1; i>=0; i--){
            suf[i]=Math.max(gap[i], suf[i+1]);
        }
        int ans = 0;
        // System.out.println(Arrays.toString(pre));
        // System.out.println(Arrays.toString(suf));
        for(int i=0;i<n;i++){
            int cur = gap[i]+gap[i+1];
            int dur = e[i]-s[i];
            if((i>0 && pre[i-1]>=dur) || (i<n-1 && suf[i+2]>=dur))
            cur+=e[i]-s[i];
            // System.out.println(s[i]+" "+e[i]+" "+cur);
            ans=Math.max(cur, ans);
        }
        return ans;

    }
}