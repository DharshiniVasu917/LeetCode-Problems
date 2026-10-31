class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> f = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            f.put(ch, f.getOrDefault(ch, 0) + 1);
        }
        boolean odd = false;
        int res = 0;
        for (Map.Entry<Character, Integer> i : f.entrySet()) {
            int val = i.getValue();
            if (val % 2 == 0) {
                res += val;
            } else {
                odd = true;
            }
        }
        if (odd == false) {
            return res;
        }
        for (Map.Entry<Character, Integer> i : f.entrySet()) {
            int val = i.getValue();
            if (val % 2 == 1) {
                res += val - 1;
            }
        }
        return res + 1;
    }
}
