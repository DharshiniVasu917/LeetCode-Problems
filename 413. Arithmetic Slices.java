class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int i=0;
        int j=2;
        if(nums.length<3){
            return 0;
        }
        int diff=nums[1]-nums[0];
        int ans=0;
        while(j<nums.length){ 
            if(nums[j]-nums[j-1]==diff){
                if(j-i+1>=3){
                    ans=ans+(j-i-1);
                }
                    j++; 
            }else{
                diff=nums[j]-nums[j-1];
                i=j-1;
                j++;
            }
        }
        return ans;
    }
}
