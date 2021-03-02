import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ImageIO {
    public static void main(String[] args) throws IOException {
        var path = Paths.get ("C:\\Users\\DCV\\Desktop\\DCV\\Docker.txt");
        var outPath = Paths.get ("C:\\Users\\DCV\\Desktop\\Bakery.png");


        // file to bytes[]
        byte[] bytes = Files.readAllBytes(Paths.get(String.valueOf(path)));

        for (byte aByte : bytes) {
            System.out.print((char) aByte);
        }
        var enc = encrypt(bytes, 45, 111);
        // bytes[] to file
          Files.write(outPath, enc);

          var dec = encrypt(Files.readAllBytes(Paths.get(String.valueOf(outPath))), 80, 78);
        Files.write(outPath, dec);

        System.out.println("Done");


        System.out.println("");
    }

    private static byte[] encrypt(byte[] bytes, int a, int b){
        int len = bytes.length;
        var byteCopy = Arrays.copyOf(bytes, len);

        for (int i = 0; i < len; i++) {
            if ((int)bytes[i] == a ){
                byteCopy[i] = (byte) b;
            } else if ((int)bytes[i] == b){
                byteCopy[i] = (byte) a;
            }
            else {
                byteCopy[i] = bytes[i];
        }
        }
        return byteCopy;
    }


}
