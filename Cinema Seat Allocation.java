import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> map = new HashMap<>();

        // Store reserved seats using bit masking
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int column = seat[1];

            map.put(
                row,
                map.getOrDefault(row, 0) | (1 << (column - 1))
            );
        }

        int answer = 0;

        // Check only rows having reserved seats
        for (int seats : map.values()) {

            // Seats 2,3,4,5
            boolean left =
                (seats & 0b0000011110) == 0;

            // Seats 4,5,6,7
            boolean middle =
                (seats & 0b0001111000) == 0;

            // Seats 6,7,8,9
            boolean right =
                (seats & 0b0111100000) == 0;

            if (left && right) {
                // Two families can sit
                answer += 2;
            }
            else if (left || middle || right) {
                // One family can sit
                answer += 1;
            }
        }

        // Rows with no reservations can fit 2 families each
        answer += (n - map.size()) * 2;

        return answer;
    }
}
