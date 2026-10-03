class NumArray {
    int[] tree ;
    int[] nums;

    public void buildTree(int st,int end, int idx, int[] nums){
        if(st == end){
            tree[idx] = nums[st];
            return;
        }
        int mid = (st+end)/2;
        buildTree(st,mid,2*idx+1,nums);
        buildTree(mid+1,end,2*idx+2,nums);

        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
    }
    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[4*nums.length];
        buildTree(0,nums.length-1,0,nums);
    }
    
    public int query(int qi,int qj,int si,int sj,int idx){
        if(qj < si || qi > sj){
            return 0;
        } else if(si >= qi && sj <=qj){
            return tree[idx];
        }else{
            int mid = (si+sj)/2;
            return query(qi,qj,si,mid,2*idx+1) + query(qi,qj,mid+1,sj,2*idx+2);
        }

    }
    public int sumRange(int left, int right) {
        return query(left,right,0,this.nums.length-1,0);    
    }

    public void updateUtil(int i,int val,int st,int end,int idx){
        if(st == end){
            if(i == st) tree[idx] = val;
            return;
        }

        int mid = (st+end)/2;
        if(i <= mid){
            updateUtil(i,val,st,mid,2*idx+1);
            tree[idx] = tree[2*idx+1] + tree[2*idx+2];
            
        }else{
            updateUtil(i,val,mid+1,end,2*idx+2);
            tree[idx] = tree[2*idx+1] + tree[2*idx+2];
        }
    }
    
    public void update(int index, int val) {
        nums[index] = val;
        updateUtil(index,val,0,nums.length-1,0);
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
