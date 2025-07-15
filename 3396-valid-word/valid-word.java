class Solution {
    public boolean isValid(String word) {
        if(word.length()<3)
        return false;
        int num=0, v=0, cO=0, r=0;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for(char c: word.toCharArray()){
            if((int)(c-'0')>=0 && (int)(c-'0')<=9){
                num++;
            }
            else if(((int)(c-'a')>=0 && (int)(c-'a')<26) || ((int)(c-'A')>=0 && (int)(c-'A')<26)){
                if(set.contains(c))
                v++;
                else cO++;
            }
            else r++;
        }
        return (r==0 && cO>0 && v>0);
    }
}