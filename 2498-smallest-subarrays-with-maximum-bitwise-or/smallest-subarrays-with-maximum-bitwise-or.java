class Solution {
    static int get(int[] a){
        int max=-1;
        for(int i=0; i<a.length; i++){
            max=Math.max(max, a[i]);
        }
        return max;
    }
    static void put(int[] bit, int n, int idx){
        // int i=0;
        for(int i=0; i<=30; i++){
            if((n&(1<<i))!=0){
                bit[i]=idx;
            }
        }
    }
    public int[] smallestSubarrays(int[] a) {
        int n=a.length;
        int[] ans = new int[n];
        int[] bit = new int[31];
        Arrays.fill(bit, 0);
        for(int i=n-1; i>=0; i--){
            if(a[i]==0){
                if(i==n-1){
                    ans[i]=1;
                }
                else if(ans[i+1]==1 && a[i+1]==0) ans[i]=1;
                else ans[i]=ans[i+1]+1;
                continue;
            }
            int num = a[i];
            put(bit, num, i);
            ans[i]=get(bit)-i+1;
            // System.out.println(Arrays.toString(bit));
        }

        return ans;
    }
}