class Solution {
    static char[] ch;
    static boolean ok(int[] dp){
        for(int i: dp){
            if(i==0)
            return false;
        }
        return true;
    }
    static int check(char c){
        if(c=='a'){
            return 0;
        }
        else if(c=='e'){
            return 1;
        }
        else if(c=='i'){
            return 2;
        }
        else if(c=='o'){
            return 3;
        }
        else if(c=='u'){
            return 4;
        }

        return -1;
    }
    
    static long atLeast(int k){
        long ans=0;
        int[] dp = new int[5];
        int n = ch.length;
        int l=0, r=0, c=0;
        while(r<=n){
            while(r<n && (!ok(dp) || c<k)){
                int chr = check(ch[r]);
                if(chr==-1){
                    c++;
                }
                else{
                    dp[chr]++;
                }
                // System.out.print(r+" ");
                r++;
            }
            // System.out.print(Arrays.toString(dp));
            if(ok(dp) && c>=k){
                ans+=(long)(n-r+1);
            }
            if(l==n)
            break;

                int chr = check(ch[l]);
                if(chr==-1){
                    c--;
                }
                else{
                    dp[chr]--;
                }
                l++;
                // System.out.print(l+"-> ");
                // System.out.print(" _"+ans+"_ ");
                // System.out.println();
        }
        return ans;
    }
    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        ch=word.toCharArray();
        return atLeast(k)-atLeast(k+1);
    }
}