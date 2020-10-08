package at.challenges.Bat;

import java.util.ArrayList;
import java.util.List;

public class GroupSum {

    public static List<Integer> matchings = new ArrayList<>();

    public static boolean groupSum(int start, int[] nums, int target) {

        if (start >= nums.length) {
            return target == 0;
        }
        if (groupSum(start + 1, nums, target - nums[start])) {
            matchings.add(nums[start]);
            return true;
        }
        if (groupSum(start + 1, nums, target)) {
            return true;
        }
        return false;
    }
}
