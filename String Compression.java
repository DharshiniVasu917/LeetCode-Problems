class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0; 

        for (int i = 0; i < n;) {
            char current = chars[i];
            int count = 0;

            while (i < n && chars[i] == current) {
                i++;
                count++;
            }

            chars[index++] = current;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}
