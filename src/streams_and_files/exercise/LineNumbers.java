package streams_and_files.exercise;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "src/streams_and_files/exercise/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        PrintWriter pw = new PrintWriter(new FileWriter("src/streams_and_files/exercise/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));
        String line = br.readLine();
        int counter = 1;

        while (line != null) {
            pw.println(counter + ". " + line);
            counter++;
            line = br.readLine();
        }

        pw.close();
    }
}
