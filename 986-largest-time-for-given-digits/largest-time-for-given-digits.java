class Solution {
    public String largestTimeFromDigits(int[] a) {
        int ans=-1;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(j==i) continue;
                for(int k=0; k<4; k++){
                    if(k==j || k==i) continue;
                    for(int l=0; l<4; l++){
                        if(l==k || l==j || l==i) continue;
                        int num = 1000*a[i]+100*a[j]+10*a[k]+a[l];
                        if(num/100<24 && num%100<60){
                            ans=Math.max(num, ans);
                        }
                    }
                }
            }
        }
        if(ans==-1) return "";
        else{
            String str = Integer.toString(ans/1000)+Integer.toString((ans%1000)/100)+":"+Integer.toString((ans%100)/10)+Integer.toString(ans%10);
            return str;
        }
    }
}