class Solution {
    static Stack<Integer> getStr1(int[][] mat, int i, int m, int n){
        int j=0;
        Stack<Integer> st = new Stack<>();
        while(j<n && i<m){
            st.push(mat[j][i]);
            j++;
            i++;
        }
        return st;
    }
    static void putStr1(int [][] mat, int i, Stack<Integer> st, int m, int n){
        int j=0;
        while(j<n && i<m){
            mat[j][i]= st.pop();
            j++;
            i++;
        }
    }

    static Stack<Integer> getStr2(int[][] mat, int i, int m, int n){
        int j=0;
        Stack<Integer> st = new Stack<>();
        while(j<m && i<n){
            st.push(mat[i][j]);
            j++;
            i++;
        }
        return st;
    }
    static void putStr2(int [][] mat, int i, Stack<Integer> st, int m, int n){
        int j=0;
        while(j<m && i<n){
            mat[i][j]= st.pop();
            j++;
            i++;
        }
    }

    public void rotate(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m/2; j++){
                int tem = mat[i][j];
                mat[i][j] = mat[i][m-j-1];
                mat[i][m-j-1]=tem;
            }
        }
        for(int i=m-2; i>=0; i--){
            Stack<Integer> st = getStr1(mat, i, m, n);
            putStr1(mat, i, st, m, n);
        }
        for(int i=n-2; i>0; i--){
            Stack<Integer> st = getStr2(mat, i, m, n);
            putStr2(mat, i, st, m, n);
        }
    }
}