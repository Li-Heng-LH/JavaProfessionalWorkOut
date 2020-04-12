package me.liheng.byteStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {

    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        int numberOfReads = 0;

        //try...finally block is used here
        //because closure of streams has to be done
        try {
            in = new FileInputStream("src/main/resources/xanadu.txt");
            out = new FileOutputStream("out/out.txt"); //out directory has to be present

            int c;

            while ((c = in.read()) != -1) {

                System.out.println(c);
                numberOfReads++;

                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            System.out.println("numberOfReads: " + numberOfReads);
        }

    }
}

//words of caution:
//Byte stream is low-level I/O that you should avoid
//Byte streams should only be used for the most primitive I/O
//Since xanadu.txt contains character data, the best approach is to use character streams
