class Solution {
    static boolean isOk(int[] ranks, int cars, long mid){
        int i=0, n=ranks.length;
        while(i<n && cars>0){
            long time=0;
            int j=0;
            while((long)ranks[i]*j*j<=mid && j<=cars+1){
                j++;
            }
            cars-=j-1;
            i++;
        }
        if(cars>0)
        return false;
        
        return true;
    }
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        int maxi=0;
        for(int i: ranks){
            maxi=Math.max(maxi,i);
        }
        long l=0,h=(long)maxi*cars*cars;
        long ans=h;
        while(l<=h){
            long mid=(l+h)/2l;
            if(isOk(ranks, cars, mid)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}