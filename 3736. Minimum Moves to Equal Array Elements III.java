class Solution {
    public long minMoves(int[] nums) {
        int mx = Integer.MIN_VALUE;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        long res = 0;
        for (int x : nums) {
            res += (mx - x);
        }
        return res;
    }
}
