class Solution {
    public int getMaxLen(int[] nums) {

        int positive = 0;
        int negative = 0;
        int answer = 0;

        for (int num : nums) {

            if (num > 0) {
                positive++;

                if (negative > 0) {
                    negative++;
                }
            }

            else if (num < 0) {
                int oldPositive = positive;
                int oldNegative = negative;

                positive = oldNegative > 0 ? oldNegative + 1 : 0;
                negative = oldPositive + 1;
            }

            else {
                positive = 0;
                negative = 0;
            }

            answer = Math.max(answer, positive);
        }

        return answer;
    }
}
