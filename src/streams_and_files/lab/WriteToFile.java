package streams_and_files.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "src\\streams_and_files\\lab\\resources\\input.txt";

        FileInputStream i = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("src\\streams_and_files\\lab\\resources\\02.WriteToFileOutput.txt");

        int bytes = i.read();
        Set<Character> punctuationTable = Set.of(',', '.', '!', '?');

        while (bytes != -1) {
            char symbol = (char) bytes;
            boolean isPunctuation = punctuationTable.contains(symbol);
            if (!isPunctuation) {
                outputStream.write(symbol);
            }

            bytes = i.read();
        }
    }
}
