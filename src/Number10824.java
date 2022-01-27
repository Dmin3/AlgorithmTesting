import java.io.IOException;
import java.util.Scanner;

public class Number10824 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String[] s1 = s.split(" ");

        long a = Long.parseLong(s1[0] + s1[1]);
        long b = Long.parseLong(s1[2] + s1[3]);
        System.out.println(a+b);

    }
}
