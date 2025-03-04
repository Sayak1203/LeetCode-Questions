class Solution {
    static int[] pow = new int[16];
    boolean solve(int n, int[] set, int j){
        // System.out.print(n+" ");
        if(n==0 || (n==1 && set[0]==0) || (n==3 && set[1]==0))
        return true;
        // else if(n<3)
        // return false;
        
        boolean b=false;
        for(int i=j-1; i>0; i--){
            if(set[i]==0 && n-pow[i]>=0){
                set[i]=1;
                b|=solve(n-pow[i], set, i);
                set[i]=0;
            }
            if(b==true)
            break;
        }
        return b;
        
    }
    public boolean checkPowersOfThree(int n) {
        for(int k=0; k<16; k++){
            pow[k]=(int)(Math.pow(3,k));
        }
        return solve(n, new int[16], 15);
    }
}