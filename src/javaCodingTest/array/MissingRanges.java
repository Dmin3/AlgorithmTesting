package javaCodingTest.array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 50, 75};
        int lower = 0;
        int upper = 99;

        System.out.println(solve(nums, lower, upper));

    }

    private static List<String> solve(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        //2-1
        if (lower < nums[0]) {
            result.add(makeRange(lower, nums[0] - 1));
        }
        //2-2
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] != nums[i + 1] && nums[i] + 1 < nums[i + 1]) {
                result.add(makeRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }
        //2-3
        if (nums[nums.length - 1] < upper) {
            result.add(makeRange(nums[nums.length - 1] + 1, upper));
        }

        return result;

    }

    private static String makeRange(int low, int high) {
        return low == high ? String.valueOf(low) : low + "->" + high;
    }


}
