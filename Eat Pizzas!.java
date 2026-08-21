import java.util.Arrays;

class Solution {
    public long maxWeight(int[] pizzas) {
        int n = pizzas.length;
        int days = n / 4;

        Arrays.sort(pizzas);

        int odd = (days + 1) / 2;
        int even = days / 2;

        long ans = 0;

        for (int i = n - odd; i < n; i++) {
            ans += pizzas[i];
        }

        int i = n - odd - 2;

        while (even > 0) {
            ans += pizzas[i];
            i -= 2;
            even--;
        }

        return ans;
    }
}
