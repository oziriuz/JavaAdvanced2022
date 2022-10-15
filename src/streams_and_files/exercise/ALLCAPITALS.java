package streams_and_files.exercise;

import java.io.*;

public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        String path = "src/streams_and_files/exercise/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        PrintWriter pw = new PrintWriter(new FileWriter("src/streams_and_files/exercise/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        bufferedReader.lines().forEach(line -> pw.print(line.toUpperCase()));

        bufferedReader.close();
        pw.close();
    }
}
