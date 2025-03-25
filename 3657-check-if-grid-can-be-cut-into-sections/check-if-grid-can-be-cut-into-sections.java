class Solution {
    static boolean solve(int[][] x){
        Arrays.sort(x,(a,b)->(a[0]-b[0]));
        int end = x[0][1];
        int n = x.length;
        int ans=0;
        for(int i=1; i<n; i++){
            if(x[i][0]>=end){
                ans++;
                end=x[i][1];
            }
            else{
                end=Math.max(end,x[i][1]);
            }
        }
        return ans>=2;
    }
    public boolean checkValidCuts(int n, int[][] rec) {
        int m=rec.length;
        int[][] x = new int[m][2];
        int[][] y = new int[m][2];
        for(int i=0; i<m; i++){
            x[i][0]=rec[i][0];
            x[i][1]=rec[i][2];
            y[i][0]=rec[i][1];
            y[i][1]=rec[i][3];
        }
        boolean b= solve(x);
        if(b==true)
        return b;
        b=solve(y);        
        return b;
    }
}