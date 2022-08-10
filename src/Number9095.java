import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Number9095 {
    static int[] nums = {1, 2, 3};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();

            res(x, 0);
            result.add(count);
            count = 0;

        }

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static void res(int x, int val) {
        if (val == x) {
            count++;
            return;
        }
        if (val > x) return;

        for (int i = 0; i < nums.length; i++) {

            val += nums[i];
            res(x, val);
            val -= nums[i];

        }
    }
}
