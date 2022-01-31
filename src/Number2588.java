import java.util.Scanner;

public class Number2588 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = b;
        int c;

        while (true) {

            c = b % 10;
            sb.append(a * c + "\n");
            b = b / 10;
            if (b == 0) {
                break;
            }
        }
        sb.append(a * d);
        System.out.println(sb);
    }
}
