class Solution {
    int[][] dp;
    int[] prefix;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        dp = new int[n][n];
        prefix = new int[n + 1];

        // Prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        return solve(stoneValue, 0, n - 1);
    }

    private int solve(int[] stones, int left, int right) {

        // Only one stone -> cannot split
        if (left == right) {
            return 0;
        }

        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        int maxScore = 0;

        for (int k = left; k < right; k++) {

            int leftSum = prefix[k + 1] - prefix[left];
            int rightSum = prefix[right + 1] - prefix[k + 1];

            if (leftSum < rightSum) {

                // Right part is discarded
                maxScore = Math.max(
                    maxScore,
                    leftSum + solve(stones, left, k)
                );

            } else if (leftSum > rightSum) {

                // Left part is discarded
                maxScore = Math.max(
                    maxScore,
                    rightSum + solve(stones, k + 1, right)
                );

            } else {

                // Equal sums -> Alice can choose either side
                maxScore = Math.max(
                    maxScore,
                    Math.max(
                        leftSum + solve(stones, left, k),
                        rightSum + solve(stones, k + 1, right)
                    )
                );
            }
        }

        return dp[left][right] = maxScore;
    }
}
