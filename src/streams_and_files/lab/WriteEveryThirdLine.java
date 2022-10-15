package streams_and_files.lab;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "src\\streams_and_files\\lab\\resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        FileOutputStream outputStream = new FileOutputStream("src\\streams_and_files\\lab\\resources\\05.WriteEveryThirdLineOutput.txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        String line = reader.readLine();

        int lineCounter = 1;
        while (line != null) {
            if (lineCounter % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }

            line = reader.readLine();
            lineCounter++;
        }

        reader.close();
        writer.close();
    }
}
