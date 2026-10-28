class Solution {
    public int findNthDigit(int n) {
        long digitLength = 1;
        long count = 9;
        long start = 1;

        // Step 1: Find the block where nth digit lies
        while (n > digitLength * count) {
            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        // Step 2: Find the exact number
        start += (n - 1) / digitLength;

        // Step 3: Find the digit inside the number
        String num = Long.toString(start);
        return num.charAt((int)((n - 1) % digitLength)) - '0';
    }
}
