package javaCodingTest.array;

import java.util.HashMap;
import java.util.Map;

//두개의 합
public class TwoSum {
    public static void main(String[] args) {
        TwoSum a = new TwoSum();
        int[] nums = {2, 8, 11, 14};
        int target = 16;
        int[] result = a.solve_for(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    private int[] solve_for(int[] nums, int target) {
        //ds
        int len = nums.length;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        //for
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                int val = map.get(nums[i]);
                result[0] = val + 1;
                result[1] = i + 1;
                return result;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[]{0, 0};
    }
}
