import java.util.Scanner;

public class Number2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[3];
        for (int i = 0; i < 3; i++) num[i] = sc.nextInt();
        if (num[0] == num[1] && num[1] == num[2] && num[2] == num[0]) System.out.print(10000 + num[0] * 1000);
        else if (num[0] == num[1]) System.out.print(1000 + num[0] * 100);
        else if (num[1] == num[2]) System.out.print(1000 + num[1] * 100);
        else if (num[2] == num[0]) System.out.print(1000 + num[2] * 100);
        else System.out.print(Math.max(Math.max(num[0], num[1]), num[2]) * 100);
    }
}
