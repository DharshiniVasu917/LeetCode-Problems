class Solution {
    boolean found = false;

    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        long sum = 0;
        for (int v : matchsticks) {
            sum += v;
        }
        if (sum % 4 != 0)
            return false;
        boolean[] taken = new boolean[n];
        backtracking(0, 0, taken, matchsticks, sum / 4, sum);
        return found;
    }

    void backtracking(int i, long currSum, boolean taken[], int[] matchsticks, long sum, long total) {
        int n = matchsticks.length;
        if (currSum > sum || total < 0) {
            return;
        }

        if (found)
            return;
        if (total == 0) {
            found = true;
            return;
        }
        if (currSum == sum) {
            backtracking(0, 0, taken, matchsticks, sum, total - sum);
            return;
        }
        if (i == n)
            return;
        backtracking(i + 1, currSum, taken, matchsticks, sum, total);
        if (!taken[i]) {
            taken[i] = true;
            backtracking(i + 1, currSum + matchsticks[i], taken, matchsticks, sum, total);
            taken[i] = false;
        }
    }
}
