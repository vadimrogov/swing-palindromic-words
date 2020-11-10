import java.util.Random;
import java.io.DataInputStream;

public class App {
    public static void main(String[] args) throws Exception {
        DataInputStream in = new DataInputStream(System.in);
        int numWords = 100;
        int wLength = 3;

        try {
            System.out.println("Enter number of words: ");
            numWords = Integer.parseInt(in.readLine());

            System.out.println("Enter words length: ");
            wLength = Integer.parseInt(in.readLine());
        } finally {
            String[] words = generateRandomWords(numWords, wLength);
            String[] pWords = new String[0];
            
            System.out.println("\n\n *** Palindromic words *** \n\n");
            for(int i = 0; i < words.length; i++) {
                if(new StringBuilder(words[i]).reverse().toString().equals(words[i])) {
                    int length = pWords.length;
                    pWords = new String[length + 1];
                    pWords[length] = words[i];
                    System.out.println(words[i]);
                }
            }
        }
    }

    public static String[] generateRandomWords(int numberOfWords, int wordsLength) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        System.out.println("\n\n *** Random words *** \n\n");
        for(int i = 0; i < numberOfWords; i++) {
            char[] word = new char[wordsLength];
            for(int j = 0; j < word.length; j++) {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
            System.out.println(randomStrings[i] + '\n');
        }
        return randomStrings;
    }
}
