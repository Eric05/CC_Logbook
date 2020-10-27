package at.challenges.Bat;

public class SplitArray_rec {

    public static boolean splitArray(int[] nums) {

        int index = 0;
        int sumLeft = 0;
        int sumRight = 0;

        return split(nums, index, sumLeft, sumRight);
    }

    public static boolean split(int[] nums, int index, int sumLeft, int sumRight) {

        if (index >= nums.length ) {
            return sumLeft == sumRight;
        }

        return split(nums, index + 1, sumLeft + nums[index], sumRight) ||
                split(nums, index + 1, sumLeft, sumRight + nums[index]);
    }
}


