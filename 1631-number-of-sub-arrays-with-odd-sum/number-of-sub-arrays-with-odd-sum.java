class Solution {
    static int mod=(int)Math.pow(10, 9)+7;
    static int f(int[] a, int i, int[] pre){
        if(i==a.length)
        return 0;
        int cnt=0;
        for(int j=0; j<=i; j++){
            if((pre[i+1]-pre[j])%2==1){
                cnt++;
            }
        }
        return (cnt+f(a, i+1, pre))%mod;
    }
    public int numOfSubarrays(int[] arr) {
        // int n = arr.length;
        // int[] pre = new int[n+1];
        // for(int i=1; i<=n; i++){
        //     pre[i]=pre[i-1]+arr[i-1];
        // }
        // int ans=0;
        
        // return ans+f(arr, 0, pre);


        int n = arr.length;
        long[] pre = new long[n];
        Arrays.fill(pre, 0l);
        for(int i=0; i<n; i++){
            arr[i]%=2;
        }
        if(arr[0]==1){
            pre[0]=1l;
        }
        for(int i=1; i<n; i++){
            if(arr[i]==0 && arr[i-1]==0){
                if(arr[i-1]==0l)
                pre[i]=pre[i-1];
                else
                pre[i]=(pre[i-1]+1l)%mod;
            }
            else if(arr[i]==0 && arr[i-1]==1){
                pre[i]=pre[i-1]%mod;
            }
            else if(arr[i]==1 && arr[i-1]==0){
                pre[i]=((long)i+1l-pre[i-1])%mod;
            }
            else if(arr[i]==1 && arr[i-1]==1){
                pre[i]=((long)i+1l-pre[i-1])%mod;
            }   
            pre[i]%=mod;         
        }
        long sum=0l;
        for(long i: pre){
            // System.out.print(i+" ");
            sum+=i%mod;
            sum%=mod;
        }
        return (int)sum;
    }
}