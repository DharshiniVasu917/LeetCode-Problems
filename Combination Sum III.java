import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(1, k, n, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int start, int k, int target,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Valid combination
        if (k == 0) {
            if (target == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        // Invalid path
        if (target <= 0) {
            return;
        }

        // Try numbers from start to 9
        for (int i = start; i <= 9; i++) {

            if (i > target) {
                break;
            }

            current.add(i);

            // i + 1 ensures we don't reuse the same number
            backtrack(i + 1, k - 1, target - i,
                      current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}
