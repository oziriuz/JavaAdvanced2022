package streams_and_files.lab;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File file = new File("src/streams_and_files/lab/resources/Files-and-Streams");
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
