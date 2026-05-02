class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((p, q)->{
            Long p1 = (long)p, q1 = (long)q;
            int i=1;
            p1*=10l;
            while(q>=Math.pow(10,i)){
                p1*=10l;
                i++;
            }
            p1+=(long)q;
            i=1;
            q1*=10l;
            while(p>=Math.pow(10,i)){
                q1*=10l;
                i++;
            }
            q1+=(long)p;
            if(p1>q1) return -1;
            else if(p1<q1) return 1;
            else return 0;
        });
        for(int i: nums)
        pq.offer(i);
        String s = "";
        while(!pq.isEmpty()){
            s+=Integer.toString(pq.poll());
        }
        if(s.charAt(0)=='0' && s.charAt(s.length()-1)=='0') return "0";
        return s;
    }
}