package at.challenges;


import at.challenges.Bat.*;
import at.challenges.Expert.PossiblePalindrome;

import java.security.NoSuchAlgorithmException;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        int[] nums1 = new int[]{5, 2, 4, 22, 4, 34, 5};
        int[] nums2 = new int[]{1,3, 12,9};


       GroupSum.groupSum(0, nums2, 22);

        var erg = GroupSum.matchings;
        System.out.println(erg);
    }
public  static void print(int[] nums){

        try {
            for (int i = 0; i < 14; i++){
                System.out.println(nums[i]);
            }
        } catch (Exception e) {

        }

}
}


