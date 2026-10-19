class Solution {

    private int pow(int x, int n, int MOD) {
        int ans = 1;
        x %= MOD;

        while (n > 0) {
            if ((n & 1) == 1) {
                ans = (ans * x) % MOD;
            }

            x = (x * x) % MOD;
            n >>= 1;
        }

        return ans;
    }

    public int superPow(int a, int[] b) {

        if (a == 1) {
            return 1;
        }

        int num = 0;

        for (int val : b) {
            num = (num * 10 + val) % 1140;
        }

        // b is positive, so remainder 0 means
        // the exponent is a positive multiple of 1140.
        if (num == 0) {
            num = 1140;
        }

        return pow(a, num, 1337);
    }
}
