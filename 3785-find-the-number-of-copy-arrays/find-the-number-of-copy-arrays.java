class Solution {
    public int countArrays(int[] or, int[][] b) {
        int n = or.length;
        long u=(long)b[0][1], d=(long)b[0][0];
        for(int i=1; i<n; i++){
            long cu=(long)or[i]+(u-(long)or[0]);
            long cd=(long)or[i]+(d-(long)or[0]);
            cu=(long)Math.min(b[i][1], cu);
            cd=(long)Math.max(b[i][0], cd);
            if(cu-cd<0l){
                return 0;
            }
            u=or[0]-(or[i]-cu);
            d=or[0]-(or[i]-cd);
        }
        return (int)(u-d+1);
    }
}