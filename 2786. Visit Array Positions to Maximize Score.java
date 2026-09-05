class Solution {
    public long maxScore(int[] nums, int x) {

        long[] dp = new long[2];

        dp[0] = Long.MIN_VALUE / 2;
        dp[1] = Long.MIN_VALUE / 2;

        dp[nums[0] % 2] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int parity = nums[i] % 2;

            long sameParity = dp[parity];

            long differentParity = dp[1 - parity] - x;

            dp[parity] =
                Math.max(sameParity, differentParity)
                + nums[i];
        }

        return Math.max(dp[0], dp[1]);
    }
}
