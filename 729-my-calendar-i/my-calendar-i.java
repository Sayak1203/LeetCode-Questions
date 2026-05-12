class MyCalendar {
    class Node{
        int start;
        int end;
        Node left;
        Node right;
        Node(int start, int end){
            this.start=start; this.end=end;
        }
    }
    Node start;
    public MyCalendar() {
        this.start=null;
    }
    
    public boolean book(int start, int end) {
        if(this.start==null){
            this.start = new Node(start, end);
            return true;
        }
        Node cur = this.start;
        while(true){
            if(cur.start>=end){
                if(cur.left==null){
                    cur.left=new Node(start, end);
                    return true;
                }
                cur=cur.left;
            }else if(cur.end<=start){
                if(cur.right==null){
                    cur.right=new Node(start, end);
                    return true;
                }
                cur=cur.right;
            }else{
                return false;
            }
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */