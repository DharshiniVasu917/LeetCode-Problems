class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }

        if(sum < Math.abs(target)) return 0;

        if((sum + target) % 2 != 0) return 0;

        int tar = (sum + target) / 2;

        int[] dp = new int[tar + 1];

        dp[0] = 1;

        for(int num : nums) {
            for(int s = tar; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }

        return dp[tar];
    }
}
