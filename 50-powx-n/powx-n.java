class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n==-1) return 1/x;

        int n2=n/2;
        double tem = n%2==0?1:n<0?1/x:x;
        double solve=myPow(x,n2);
        return tem*solve*solve;
    }
}