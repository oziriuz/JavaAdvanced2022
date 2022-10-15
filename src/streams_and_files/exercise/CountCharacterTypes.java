package streams_and_files.exercise;

import java.io.FileReader;
import java.io.IOException;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "src/streams_and_files/exercise/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        FileReader fileReader = new FileReader(path);

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;
        int oneByte = fileReader.read();

        while (oneByte >= 0) {
            char symbol = (char) oneByte;
            if (isVowel(symbol)) {
                vowels++;
            } else if (isPunctuation(symbol)) {
                punctuation++;
            } else if (!Character.isWhitespace(symbol)) {
                consonants++;
            }
            oneByte = fileReader.read();
        }

        fileReader.close();
        System.out.printf("Vowels: %d%n", vowels);
        System.out.printf("Consonants: %d%n", consonants);
        System.out.printf("Punctuation: %d%n", punctuation);
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '!' || symbol == '.' || symbol == ',' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        return (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u');
    }
}
