class Solution {
    public static String process(List<String> tem, int m, int cnt){
        int space = m-cnt;
        int n = tem.size();
        String s = new String();
        if(n==1){
            s+=tem.get(0);
            while(space-->0){
                s+=" ";
            }
            return s;
        }
        int e = space/(n-1);
        int mod = space%(n-1);
        for(int i=0; i<n-1; i++){
            s+=tem.get(i);
            for(int j=0; j<e; j++){
                s+=" ";
            }
            if(mod>0){
                s+=" ";
                mod--;
            }
        }
        s+=tem.get(n-1);
        return s;
    }
    public static String processLast(List<String> tem, int m, int cnt){
        int n = tem.size();
        int space = m-cnt-n+1;
        String s = new String();
        if(n==1){
            s+=tem.get(0);
            while(space-->0){
                s+=" ";
            }
            return s;
        }
        for(int i=0; i<n-1; i++){
            s+=tem.get(i);
            s+=" ";
        }
            s+=tem.get(n-1);
        for(int i=0; i<space; i++){
            s+=" ";
        }
        return s;
    }
    public List<String> fullJustify(String[] w, int m) {
        // int i=0;
        List<String> l = new ArrayList<>();
        List<String> tem = new ArrayList<>();
        int cnt=0;
        for(String i: w){
            if(i.length()+cnt+tem.size()>m){
                l.add(process(tem, m, cnt));
                cnt=0;
                tem=new ArrayList<>();
                cnt+=i.length();
                tem.add(i);
            }
            else{
                cnt+=i.length();
                tem.add(i);
            }
        }
                l.add(processLast(tem, m, cnt));

        return l;

    }
}