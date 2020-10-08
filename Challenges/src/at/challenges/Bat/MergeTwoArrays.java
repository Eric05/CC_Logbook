package at.challenges.Bat;

/***
 * merge two sorted arrays of (maybe ) different length
 * O (n) time
 //* @param sorted array
 //* @param sorted array
 * @return merged array
 */

public class MergeTwoArrays {

    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        int[] merged = new int[(a.length + b.length)];
        int counter = 0;
        int i = 0;
        int j = 0;

        while (counter < merged.length) {

            if (i < a.length && j >= b.length) {
                merged[counter] = a[i];
                counter++;
                i++;
            } else if (j < b.length && i >= a.length) {
                merged[counter] = a[j];
                counter++;
                j++;
            } else if (a[i] <= b[j]) {
                merged[counter] = a[i];
                counter++;
                i++;
            } else {
                merged[counter] = b[j];
                counter++;
                j++;
            }
        }
        return merged;
    }
}




