import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        
        int[] count = new int[5]; // a, e, i, o, u
        String vowels = "aeiou";
        
        for (char c : s.toCharArray()) {
            int idx = vowels.indexOf(c);
            if (idx != -1) {
                count[idx]++;
            }
        }
        
        int maxIdx = 0;
        for (int i = 1; i < 5; i++) {
            if (count[i] > count[maxIdx]) {
                maxIdx = i;
            }
        }
        
        System.out.println(vowels.charAt(maxIdx));
    }
}
