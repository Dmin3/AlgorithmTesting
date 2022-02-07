package javaCodingTest.string;

// 플러스 원
public class PlusOne {
    public static void main(String[] args) {
//        int[] digits = {1, 2, 3};
        int[] digits = {9, 9, 9};

        int[] result = solve(digits);

        for (int i : result) {
            System.out.println("val = " + i);
        }

    }

    private static int[] solve(int[] digits) {

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++; // 마지막 배열 +1
            if (digits[i] < 10) {
                return digits;
            }
            // 마지막 배열이 0보다 크다면 전부 0 으로 초기화
            digits[i] = 0;
        }

        int[] result = new int[n + 1];
        result[0] = 1; // 1,0,0,0

        return result;
    }


}
