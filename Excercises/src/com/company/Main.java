package com.company;


import com.company.November.Day_29.Human;
import com.company.November.Day_29.View;
import com.company.November.MovingKnight.GameController;
import com.company.November.camera.Camera;
import com.company.November.camera.CameraView;
import com.company.November.camera.MockPicture;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Main {

    public static void main(String[] args) throws IOException {

        String[] names = new String[]{"a", "v", "w"};
        var res = linearSearch(names, "v");
        System.out.println(res);

/*        var path = "C:\\dev\\Adresses.txt";
        File file = new File(path);
        file.createNewFile();
        Files.writeString(Path.of(path), "Hallo");*/
    }

    public static int linearSearch(String[] strings, String string) {
        int tries = 0;
        for (String str : strings) {
            tries++;
            if (str.equals(string)) {
                return tries;
            }
        }
        return -1;
    }
}












