class NumArray {
    int[] a;
    int[] seg;
    public void build(int i, int left, int right){
        if(left==right) seg[i]= a[left];
        else {
            int mid = left+(right-left)/2;
            build(2*i+1, left, mid);
            build(2*i+2, mid+1, right);
            seg[i]=seg[2*i+1]+seg[2*i+2];
        }
    }

    public NumArray(int[] nums) {
        this.a=nums;
        seg=new int[4*nums.length-1];
        build(0, 0, nums.length-1);
    }
    
    public void update(int index, int val) {
        a[index]=val;
        change(0, 0, a.length-1, index, val);
    }
    public void change(int node, int l, int r, int idx, int val){
        if(l==r){ 
            seg[node]=val;
        }
        else{
            int m = l+(r-l)/2;
            if(l<=idx &&  idx<=m){
                change(2*node+1, l, m, idx, val);
            }else
                change(2*node+2, m+1, r, idx, val);
            seg[node]=seg[2*node+1]+seg[2*node+2];
        }
    }
    public int calc(int i, int left, int right, int low, int high){
        if(low>=left && high <=right) return seg[i];
        else if(high<left || low>right) return 0;

        int mid = low+(high-low) /2;
        int l = calc(2*i+1, left, right, low, mid);
        int r = calc(2*i+2, left, right, mid+1, high);
        return l+r;

    }
    public int sumRange(int left, int right) {
        return calc(0, left, right, 0, a.length-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */