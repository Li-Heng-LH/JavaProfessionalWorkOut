package characterStreams;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {

    public static void main(String[] args) throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("src/main/resources/xanadu.txt");
            outputStream = new FileWriter("out/out.txt");


        } finally {

        }

    }
}
