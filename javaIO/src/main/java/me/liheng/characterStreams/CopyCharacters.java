package me.liheng.characterStreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {

    public static void main(String[] args) throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;
        int numberOfReads = 0;

        try {
            inputStream = new FileReader("src/main/resources/xanadu.txt"); //relative path
            outputStream = new FileWriter("out/out.txt"); //relative path

            //in CopyCharacters, the int variable holds a character value in its last 16 bits;
            //in CopyBytes, the int variable holds a byte value in its last 8 bits.
            int c;

            while ((c = inputStream.read()) != -1) {

                System.out.println(c);
                numberOfReads++;

                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            System.out.println("numberOfReads: " + numberOfReads);
        }
    }
}
