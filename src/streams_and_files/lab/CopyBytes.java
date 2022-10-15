package streams_and_files.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "src\\streams_and_files\\lab\\resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("src\\streams_and_files\\lab\\resources\\03.CopyBytesOutput.txt");

        int oneByte = 0;
        while ((oneByte = inputStream.read()) >= 0){
            if(oneByte == 10 || oneByte == 32){
                outputStream.write(oneByte);
            }else {
                String digits = String.valueOf(oneByte);
                for (int i = 0; i < digits.length(); i++) {
                    outputStream.write(digits.charAt(i));
                }
            }
        }
    }
}
