package at.challenges;


import at.challenges.Bat.*;
import at.challenges.Classics.Conway;
import at.challenges.Expert.PossiblePalindrome;

import java.io.Console;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;
import java.util.logging.ConsoleHandler;


public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        int[] nums1 = new int[]{5, 2, 4, 22, 4, 34, 5};
        int[] nums2 = new int[]{2,3};

        var c = new Conway(10, 12);
        c.runSimulation();




        //var x = GroupSum_rec.groupSum(0,nums2, 4);

        //var erg = CountXY.countYZ("fez day dyz as", true);
        //System.out.println(erg);
    }




}


