package me.liheng.byteStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {

    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        //try...finally block is used here
        //because closure of streams has to be done
        try {
            in = new FileInputStream("src/main/resources/xanadu.txt");
            out = new FileOutputStream("out/out.txt"); //out directory has to be present

            int c; //Can I use Byte???
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

    }
}
