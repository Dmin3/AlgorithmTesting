import java.util.Scanner;

public class Number10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 1;

        for (int i = n; i > 0; i--) {

            sum *= i;
        }
        if (n == 0) {
            System.out.println(1);
        } else {
            System.out.println(sum);
        }
    }
}
