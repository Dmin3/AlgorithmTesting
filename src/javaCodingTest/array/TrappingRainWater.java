package javaCodingTest.array;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(solve(height));
    }

    private static int solve(int[] height) {
        int result = 0;
        if (height == null || height.length <= 2) {
            return result;
        }
        //ds
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        //leftMax[]
        int max = height[0];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            if (height[i] < max){
                left[i] = max;
            } else {
                left[i] = height[i];
                max = height[i];
            }
        }

        //rightMax[]
        max = height[len-1];
        right[len-1] = height[len-1];
        for (int i = len - 2; i >= 0; i--) {
            if (height[i] < max){
                right[i] = max;
            } else {
                right[i] = height[i];
                max = height[i];
            }
        }

        //result
        for (int i = 0; i < len; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }
}
