import java.util.HashMap;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text");
        String text = scanner.nextLine();
        String[] sentences = text.split("[.!?]");
        for (String sentence : sentences) {
            HashMap<String, Integer> hashmap_of_letters = new HashMap<>();
            hashmap_of_letters.put("vowel", 0);
            hashmap_of_letters.put("consonant", 0);
            char[] char_array = sentence.toCharArray();
            for (char c : char_array) {
                if (Character.isLetter(c)) {
                    if (isConsonant(c)) {
                        hashmap_of_letters.compute("consonant", (key, val) -> val + 1);
                    } else if (isVowel(c)) {
                        hashmap_of_letters.compute("vowel", (key, val) -> val + 1);
                    }
                }
            }
            if (hashmap_of_letters.get("consonant") > hashmap_of_letters.get("vowel")) {
                System.out.println("Consonants are more");
            } else if (hashmap_of_letters.get("vowel") > hashmap_of_letters.get("consonant")) {
                System.out.println("Vowels are more");
            }
            else {
                System.out.println("There are as many consonants as there are vowels");
            }
        }
    }

    public static boolean isConsonant(char letter) {
        letter = Character.toLowerCase(letter);
        return letter >= 'a' && letter <= 'z' && "aeiou".indexOf(letter) == -1;
    }

    public static boolean isVowel(char letter) {
        String vowels = "AEIOUaeiou";
        return vowels.indexOf(letter) != -1;
    }
}
