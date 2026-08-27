class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Count characters in s1
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }

        // First window in s2
        for (int i = 0; i < s1.length(); i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (matches(count1, count2)) {
            return true;
        }

        int left = 0;

        // Slide the window
        for (int right = s1.length(); right < s2.length(); right++) {

            // Add new character
            count2[s2.charAt(right) - 'a']++;

            // Remove old character
            count2[s2.charAt(left) - 'a']++;

            count2[s2.charAt(left) - 'a'] -= 2;

            left++;

            if (matches(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] count1, int[] count2) {

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }
}
