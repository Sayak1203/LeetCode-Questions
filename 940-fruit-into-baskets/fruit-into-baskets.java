class Solution {
    public int totalFruit(int[] a) {
        int i=0, j=0;
        int ans=0;
        int n = a.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(i<n){
            while(map.size()<3 && i<n){
                map.put(a[i], map.getOrDefault(a[i],0)+1);
                // System.out.print("i="+i+" ");
                ans=Math.max(ans, i-j);
                i++;
            }
            if(i==n && map.size()<3)
                ans=Math.max(ans, i-j);
            // System.out.print(i+" "+j+" "+ans+" ");
            while(map.size()>2){
                map.put(a[j], map.getOrDefault(a[j],0)-1);
                if(map.get(a[j])==0){
                    map.remove(a[j]);
                }
                // System.out.print("j="+j+" ");
                j++;
            }

        }
        return ans;
    }
}