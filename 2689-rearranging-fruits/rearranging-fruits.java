class Solution {
    public long minCost(int[] a, int[] b) {
        int n = a.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int min=a[0];
        for(int i: a){
            map.put(i, map.getOrDefault(i,0)+1);
            map2.put(i, map2.getOrDefault(i,0)+1);
            min=Math.min(min,i);
        }
        for(int i: b){
            map.put(i, map.getOrDefault(i,0)+1);
            min=Math.min(min,i);
        }
        ArrayList<Integer> ar = new ArrayList<>();
        for(Map.Entry<Integer, Integer> ele: map.entrySet()){
            int dem = ele.getValue();
            if(dem%2==1)
            return -1;
            dem/=2;
            for(int i=0; i<Math.abs(dem-map2.getOrDefault(ele.getKey(), 0)); i++){
                ar.add(ele.getKey());
            }
        }
        // System.out.println(ar);
        Collections.sort(ar);
        long sum=0l;
        for(int i=0; i<ar.size()/2; i++){
            sum+=(long)Math.min(min*2, ar.get(i));
        }
        return sum;


    }
}