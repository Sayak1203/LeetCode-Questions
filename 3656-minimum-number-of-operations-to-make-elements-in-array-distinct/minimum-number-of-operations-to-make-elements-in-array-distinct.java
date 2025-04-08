class Solution {
    public int minimumOperations(int[] a) {
        // HashMap<Integer,Integer> map = new HahsMap<>();
        HashSet<Integer> set = new HashSet<>();
        // for(int i=0; i<n; i++){
        //     map.put(a[i], map.getOrDefault(a[i],0)+1);
        //     if(map.get(a[i])>1){
        //         set.add(a[i]);
        //     }
        // }
        int n = a.length;
        int i = n-1;
        int ans= (n-1)/3+1;
        for(i=n-1; i>=(n/3)*3; i--){
            if(set.contains(a[i]))
            return ans;
            set.add(a[i]);
        }
        if(n%3>0)
        ans--;
        while(i>0){
            for(int j=0; j<3; j++){
                if(set.contains(a[i]))
                return ans;
                set.add(a[i]);
                // System.out.println(i+" "+a[i]);
                i--;
            }
            ans--;
        }
        return ans;

    }
}