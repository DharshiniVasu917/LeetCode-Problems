class Solution {

    public long findMaximumNumber(long k, int x) {

        long left = 1;
        long right = 1L << 50;

        while (left < right) {

            long mid = left + (right - left + 1) / 2;

            if (getTotalPrice(mid, x) <= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private long getTotalPrice(long n, int x) {

        long total = 0;

        for (int pos = x; pos <= 50; pos += x) {

            long half = 1L << (pos - 1);
            long cycle = half * 2;

            long count = n + 1;

            total += (count / cycle) * half;

            long remainder = count % cycle;

            total += Math.max(0L, remainder - half);
        }

        return total;
    }
}
