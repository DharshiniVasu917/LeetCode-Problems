import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row=seat[0];
            int column=seat[1];
            map.put(
                row,
                map.getOrDefault(row, 0) | (1 << (column - 1))
            );
        }
        int answer=0;
        for (int seats : map.values()) {
            boolean left =
                (seats & 0b0000011110)==0;
            boolean middle =
                (seats & 0b0001111000) == 0;
            boolean right =
                (seats & 0b0111100000) == 0;

            if (left && right) {
                answer += 2;
            }
            else if (left || middle || right) {
                answer += 1;
            }
        }
        answer += (n - map.size()) * 2;
        return answer;
    }
}
