class Solution {
    static boolean bouquet(int[] day, int mid, int m, int k){
        int flower=0;
        for(int i: day){
            if(i<=mid){
                flower++;
            }else{
                flower=0;
            }
            if(flower>=k) {
                flower=0;
                m--;
            }
        }
        if(m>0)
        return false;
        return true;
    }
    public int minDays(int[] day, int m, int k) {
        int max = day[0];
        for(int i: day){
            max = Math.max(max, i);
        }
        int low = 1, high = max;
        int ans=-1; 
        while(low<=high){
            int mid = low+(high-low)/2;
            if(bouquet(day, mid, m, k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
            // System.out.println(ans);
        }
        return ans;
    }
}