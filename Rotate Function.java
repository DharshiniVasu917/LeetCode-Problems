class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        long F=0L,res=0L,sum=0L,nLong=n;

        for(int i=0;i<n;++i) {
            F += (long)i*nums[i];
            sum += nums[i];
        }
        
        res=F;
        
        for(int i=n-1;i>0;--i){
            F = F + sum - nLong * nums[i];
            if(F>res) res=F;
        }

        return (int)res;

    }
}
