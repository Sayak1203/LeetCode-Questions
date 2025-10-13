class Solution {
    public static int threeChar(String str){
        char[] s = str.toCharArray();
        int n = str.length();
        HashMap<String, Integer> map = new HashMap<>();
        map.put(Arrays.toString(new int[]{0,0}), -1);
        int a=0, b=0, c=0;
        int ans = 0;
        for(int i=0; i<n; i++){
            char ch=s[i];
            if(ch=='a') a++;
            else if(ch=='b') b++;
            else c++;

            int p = a-b, q=a-c;
            String st = Arrays.toString(new int[]{p,q});
            if(map.containsKey(st)){
                ans=Math.max(ans, i-map.get(st));
            }else{
                map.put(st,i);
            }
        }
        return ans;
    }
    public static int twoChar(String str, char a, char b){
        String c ="c";
        if(a!='a' && b!='a') c="a";
        else if(a!='b' && b!='b') c="b";
        String[] s = str.split(c);

        // System.out.println(Arrays.toString(s));
        int ans=0;
        for(String ST: s){
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int p=0, q=0;
            char[] st = ST.toCharArray();
            for(int i=0; i<st.length; i++){
                if(st[i]==a) p++;
                else q++;
                int num = p-q;
                if(map.containsKey(num)){
                    ans=Math.max(ans, i-map.get(num));
                    // System.out.println(Arrays.toString(new int[]{ans, i}));
                }
                else{
                    map.put(num,i);
                }
            }
        }
        return ans;
    }
    public static int oneChar(String str, char a){
        char[] s = str.toCharArray();
        int n = str.length();
        int cnt=0;
        int ans=0;
        for(char ch: s){
            if(ch==a){
                cnt++;
            }
            else cnt=0;

            ans=Math.max(ans, cnt);
        }
        return ans;
    }
    public int longestBalanced(String str) {
        int a = threeChar(str);
        int b = twoChar(str, 'a', 'b');
        int c = twoChar(str, 'c', 'b');
        int d = twoChar(str, 'a', 'c');
        int e = oneChar(str, 'a');
        int f = oneChar(str, 'b');
        int g = oneChar(str, 'c');
        return Math.max(Math.max(Math.max(a,b), Math.max(c,d)), Math.max(Math.max(e,f), g));
    }
}