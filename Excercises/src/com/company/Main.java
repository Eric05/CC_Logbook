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
import java.util.List;
import java.util.Random;


public class Main {

    public static void main(String[] args) throws IOException {

        var path = "C:\\dev\\Adresses.txt";

        File file = new File(path);
        file.createNewFile();
        Files.writeString(Path.of(path), "Hallo");
    }

}












