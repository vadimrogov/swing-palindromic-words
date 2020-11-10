import java.util.Random;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class App extends JFrame {
    private static final long serialVersionUID = 1L;

    public static final Font FONT = new Font("Verdana", Font.PLAIN, 11);
    
    public static void createGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        String input1 = JOptionPane.showInputDialog(null, "Enter number of words: ");
        String input2 = JOptionPane.showInputDialog(null, "Enter words length: ");
        int numWords = Integer.parseInt(input1);
        int wLength = Integer.parseInt(input2);

        String[] words = generateRandomWords(numWords, wLength);
        String[] pWords = new String[0];
        
        for(int i = 0; i < words.length; i++) {
            if(new StringBuilder(words[i]).reverse().toString().equals(words[i])) {
                pWords = push(pWords, words[i]);
            }
        }

        JOptionPane.showMessageDialog(null, stringify(words), "*** Random words ***", JOptionPane.INFORMATION_MESSAGE);
        
        String pWordsText = "Nothing to say";
        if(pWords.length > 0) {
            pWordsText = stringify(pWords);
        }
        JOptionPane.showMessageDialog(null, pWordsText, "*** Palindromic words ***", JOptionPane.INFORMATION_MESSAGE);
    }
     
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("Button.font", FONT);
                UIManager.put("Label.font", FONT);              
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }

    public static String[] generateRandomWords(int numberOfWords, int wordsLength) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++) {
            char[] word = new char[wordsLength];
            for(int j = 0; j < word.length; j++) {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    public static String stringify(String[] arr) {
        String txt = "";
        for(int i = 0; i < arr.length; i++) {
            txt = txt + "\n" + arr[i];
        }
        return txt;
    }

    private static String[] push(String[] array, String push) {
        String[] longer = new String[array.length + 1];
        System.arraycopy(array, 0, longer, 0, array.length);
        longer[array.length] = push;
        return longer;
    }
}
