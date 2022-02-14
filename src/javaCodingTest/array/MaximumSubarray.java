package javaCodingTest.array;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray a = new MaximumSubarray();
        int result = a.solve(nums);
        System.out.println(result);
    }


    private int solve(int[] nums) {
        // 초기화
        int curMax = nums[0];
        int allMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 비교
            curMax = Math.max(nums[i], nums[i] + curMax);
            allMax = Math.max(allMax, curMax);
        }
        return allMax;
    }

}
