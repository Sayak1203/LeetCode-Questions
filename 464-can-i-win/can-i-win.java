class Solution {
    Map<Integer, Boolean> map;
    
    public boolean solve(int m, int used, int n){
        if(n<=0){
            return false;
        }
        if(map.containsKey(used))
        return map.get(used);
        boolean ans=false;
        for(int i=1; i<=m && ans==false; i++){
            if((used&(1<<i))==0){
                int newUsed = used|(1<<i);
                ans|=!solve(m,newUsed,n-i);
            }
        }
        map.put(used, ans);
        return ans;
    }
    public boolean canIWin(int m, int n) {
        if(m>=n) return true;
        if((m*(m+1))/2<n) return false;
        map = new HashMap<>();
        return solve(m,0,n);
    }
}