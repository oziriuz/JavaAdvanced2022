package streams_and_files.exercise;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class GetFolderSize {
    public static void main(String[] args) {
        File folder = new File("src/streams_and_files/exercise/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources");
        Deque<File> directories = new ArrayDeque<>();
        directories.offer(folder);

        int sumOfBytes = 0;

        while (!directories.isEmpty()) {
            File current = directories.poll();
            File[] files = current.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    directories.offer(file);
                } else {
                    sumOfBytes += file.length();
                }
            }
        }

        System.out.println( "Folder size: "+sumOfBytes);
    }
}
