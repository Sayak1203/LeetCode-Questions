class Solution {
    public List<List<Integer>> fourSum(int[] a, int tar) {
        int n = a.length;
        List<List<Integer>> ar = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<Long> map = new HashSet<>();
        // for(int i=0; i<n; i++){
            map.add((long)a[0]);
            for(int j=1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    for(int l=k+1; l<n; l++){
                        int first=-1;
                        // System.out.println(a[j]+" "+a[k]+" "+a[l]+" "+map);
                        if(map.contains((long)tar-(long)a[j]-(long)a[k]-(long)a[l])){
                            first=(int)((long)tar-(long)a[j]-(long)a[k]-(long)a[l]);
                        }else{
                            continue;
                        }
                        if((long)first+(long)a[j]+(long)a[k]+(long)a[l]==(long)tar){
                            List<Integer> tem = new ArrayList<>();
                            
                            int[] ar2 = new int[]{first, a[j], a[k], a[l]};
                            Arrays.sort(ar2);
                            tem.add(ar2[0]);
                            tem.add(ar2[1]);
                            tem.add(ar2[2]);
                            tem.add(ar2[3]);
                            String s = Arrays.toString(ar2);
                            if(set.contains(s)){
                                continue;
                            }else{
                                set.add(s);
                                ar.add(tem);
                            }
                        }
                    }
                }
                map.add((long)a[j]);
            }
        // }
        return ar;
    }
}