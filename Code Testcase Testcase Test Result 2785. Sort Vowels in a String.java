import java.util.*;

class Solution {
    public String sortVowels(String s) {

        List<Character> vowels = new ArrayList<>();

        // Store all vowels
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowels.add(ch);
            }
        }

        // Sort vowels
        Collections.sort(vowels);

        StringBuilder result = new StringBuilder();

        int index = 0;

        // Build the answer
        for (char ch : s.toCharArray()) {

            if (isVowel(ch)) {
                result.append(vowels.get(index));
                index++;
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' ||
               ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' ||
               ch == 'O' || ch == 'U';
    }
}
