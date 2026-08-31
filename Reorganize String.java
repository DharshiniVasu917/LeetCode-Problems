import java.util.*;

class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        int[] previous = null;

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            // Same character as previous
            if (previous != null && current[0] == previous[0]) {

                if (pq.isEmpty()) {
                    return "";
                }

                int[] next = pq.poll();

                result.append((char) (next[0] + 'a'));
                next[1]--;

                if (next[1] > 0) {
                    pq.offer(next);
                }

                pq.offer(current);
                previous = next;

            } else {

                result.append((char) (current[0] + 'a'));
                current[1]--;

                if (current[1] > 0) {
                    pq.offer(current);
                }

                previous = current;
            }
        }

        return result.toString();
    }
}
