class Solution {
    public int countDays(int d, int[][] meet) {
        Arrays.sort(meet,(a,b)->(a[0]-b[0]));
        int ans=0;
        ans+=meet[0][0]-1;
        int end=meet[0][1];
        int n = meet.length;
        for(int i=1; i<n; i++){
            if(meet[i][0]<=end){
                end=Math.max(end,meet[i][1]);
            }
            else{
                ans+=meet[i][0]-end-1;
                end=meet[i][1];
            }
        }
        ans+=d-end;
        return ans;
    }
}