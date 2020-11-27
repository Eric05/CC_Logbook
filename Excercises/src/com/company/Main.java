package com.company;


import com.company.November.Day_29.Human;
import com.company.November.Day_29.View;
import com.company.November.MovingKnight.GameController;
import com.company.November.camera.Camera;
import com.company.November.camera.CameraView;
import com.company.November.camera.MockPicture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

    static Random r = new Random();

    public static void main(String[] args) {

        Camera cam = new Camera("nikon", 2020, 200,true);

        for (int i = 0; i < 7; i++) {
            cam.makePicture();
        }

        var pictures = cam.getPictures();
        CameraView.printAllPictures(pictures);

        var s = cam.searchPicture("natur");
    }


}












