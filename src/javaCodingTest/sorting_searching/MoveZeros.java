package javaCodingTest.sorting_searching;

import java.util.Arrays;

//제로 이동
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 0, 8, 5};

        int len = nums.length;
        int index = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }

        while (index < len) {
            nums[index] = 0;
            index++;
        }

//        for (int i : nums) {
//            System.out.println("val = " + i);
//        }
        System.out.println(Arrays.toString(nums));




    }


}
