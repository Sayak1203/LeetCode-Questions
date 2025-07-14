class Solution {
    static void streverse(int[] st, int n){
        int l=0;
        n--;
        while(l<n){
            int tem=st[l];
            st[l]=st[n];
            st[n]=tem;
            l++;
            n--;
        }
        
    }
    static int[] getStr(int[][] g, int i){
        int j=0;
        int n = g.length;
        int[] st = new int[n];
        while(i<g.length){
            st[j]=g[i][j];
            i++;
            j++;
        }
        return st;
    }
    void putStr(int[][] g, int i, int[] st){
        int j=0;
        while(i<g.length){
            g[i][j]=st[j];
            i++;
            j++;
        }
    }
    static int[] getStr1(int[][] g, int i){
        int j=0;
        int n = g.length;
        int[] st = new int[n];
        while(i<g.length){
            st[j]=g[j][i];
            i++;
            j++;
        }
        return st;
    }
    void putStr1(int[][] g, int i, int[] st){
        int j=0;
        while(i<g.length){
            g[j][i]=st[j];
            i++;
            j++;
        }
    }
    static int[] getStr2(int[][] g, int i){
        int j=0;
        int n = g.length;
        int[] st = new int[n];
        while(j<g.length){
            st[j]=g[j][i];
            j++;
        }
        return st;
    }
    void putStr2(int[][] g, int i, int[] st){
        int j=0;
        while(j<g.length){
            g[j][i]=st[j];
            j++;
        }
    }
    public void rotate(int[][] g) {
        int n = g.length;
        for(int i=0; i<n; i++){
            int[] st = getStr(g, i);
            streverse(st, n-i);
            putStr(g, i, st);
        }
        for(int i=1; i<n; i++){
            int[] st = getStr1(g, i);
            streverse(st, n-i);
            putStr1(g, i, st);
        }
        // for(int[] i: g)
        // System.out.println(Arrays.toString(i));
        for(int i=0; i<n; i++){
            int[] st = getStr2(g, i);
            streverse(st, n);
            putStr2(g, i, st);
        }
        // for(int[] i: g)
        // System.out.println(Arrays.toString(i));
        
    }
}