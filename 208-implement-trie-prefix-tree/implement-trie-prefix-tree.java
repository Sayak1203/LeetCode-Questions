class Node{
    Node[] links = new Node[26]; 
    boolean f=false;
    public Node(){

    }

    boolean containsKey(char c){
        return links[c-'a']!=null;
    }
    void put(char ch){
        links[ch-'a']=new Node();
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    void setEnd(){
        f=true;
    }
    boolean isEnd(){
        return (f==true);
    }
}
class Trie {
    private static Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) {
        Node n = root;
        for(char ch : word.toCharArray()){
            if(!n.containsKey(ch)){
                n.put(ch);
            }
            n=n.get(ch);
        }
        n.setEnd();
    }

    boolean search(String word) {
        Node n = root;
        for(char ch: word.toCharArray()){
            if(n.containsKey(ch)==false)
            return false;
            n=n.get(ch);
        }
        if(n.isEnd())
        return true;

        return false;
    }

    boolean startsWith(String prefix) {
        Node n = root;
        for(char ch: prefix.toCharArray()){
            if(n.containsKey(ch)==false)
            return false;
            n=n.get(ch);
        }
        // if(n.isEnd())
        // return false;

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */