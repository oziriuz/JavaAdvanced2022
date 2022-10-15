package streams_and_files.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args)throws IOException {
        Path firstFile  = Paths.get("src/streams_and_files/exercise/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt");
        List<String> firstFileLines = Files.readAllLines(firstFile);

        Path secondFile  = Paths.get("src/streams_and_files/exercise/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt");
        List<String> secondFileLines = Files.readAllLines(secondFile);

        Path output =Paths.get("src/streams_and_files/exercise/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt");
        Files.write(output,firstFileLines);
        Files.write(output,secondFileLines, StandardOpenOption.APPEND);
    }
}
