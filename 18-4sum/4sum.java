class Solution {
    public List<List<Integer>> fourSum(int[] a, int tar) {
        int n = a.length;
        List<List<Integer>> ar = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    for(int l=k+1; l<n; l++){
                        if((long)a[i]+(long)a[j]+(long)a[k]+(long)a[l]==(long)tar){
                            List<Integer> tem = new ArrayList<>();
                            tem.add(a[i]);
                            tem.add(a[j]);
                            tem.add(a[k]);
                            tem.add(a[l]);
                            int[] ar2 = new int[]{a[i], a[j], a[k], a[l]};
                            Arrays.sort(ar2);
                            String s = Arrays.toString(ar2);
                            if(set.contains(s)){
                                break;
                            }else{
                                set.add(s);
                                ar.add(tem);
                            }
                        }
                    }
                }
            }
        }
        return ar;
    }
}