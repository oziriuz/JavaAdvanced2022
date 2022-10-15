package streams_and_files.lab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {

        String path = "src\\streams_and_files\\lab\\resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            int bytes = fileInputStream.read();

            while (bytes != -1) {
                System.out.print(Integer.toBinaryString(bytes) + " ");
                bytes = fileInputStream.read();
            }

            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
