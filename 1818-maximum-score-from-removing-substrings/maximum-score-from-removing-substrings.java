class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> st = new Stack<>();
        char a, b;
        int ans=0;
        if(x>y){
            a='a'; b='b';
        }
        else{
            a='b'; b='a';
        }
            for(char c: s.toCharArray()){
                if(st.isEmpty()){
                    st.push(c);
                }else if(c==b && st.peek()==a){
                    st.pop();
                    ans+=Math.max(x,y);
                }else st.push(c);
            }
            Stack<Character> st2 = new Stack<>();
            while(!st.isEmpty()){
                char c = st.pop();
                if(st2.isEmpty()){
                    st2.push(c);
                }else if(c==b && st2.peek()==a){
                    st2.pop();
                    ans+=Math.min(x,y);
                }else st2.push(c);
            }

        return ans;
    }
}