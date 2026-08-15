class Solution {
    public int longestSubsequence(int[] nums) {

        int n = nums.length;
        int xor = 0;
        int zeroCount = 0;

        for (int num : nums) {
            xor ^= num;

            if (num == 0) {
                zeroCount++;
            }
        }

        // Entire array has non-zero XOR
        if (xor != 0) {
            return n;
        }

        // All elements are zero
        if (zeroCount == n) {
            return 0;
        }

        // Remove one non-zero element
        return n - 1;
    }
}
