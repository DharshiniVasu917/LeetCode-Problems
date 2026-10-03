class Solution {

    public boolean isAdditiveNumber(String num) {

        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {

            if (num.charAt(0) == '0' && i > 1)
                break;

            long first = Long.parseLong(num.substring(0, i));

            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {

                if (num.charAt(i) == '0' && j > 1)
                    break;

                long second = Long.parseLong(num.substring(i, i + j));

                if (backtrack(first, second, i + j, num))
                    return true;
            }
        }

        return false;
    }

    private boolean backtrack(long first,
                              long second,
                              int index,
                              String num) {

        if (index == num.length())
            return true;

        long sum = first + second;

        String next = String.valueOf(sum);

        if (!num.startsWith(next, index))
            return false;

        return backtrack(second,
                         sum,
                         index + next.length(),
                         num);
    }
}
