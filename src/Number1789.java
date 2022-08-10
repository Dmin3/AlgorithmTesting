import java.util.Scanner;

public class Number1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        long s = Long.parseLong(a);

        long sum = 0;
        long i = 1;
        long count = 0;
        while (true){
            sum += i;

            if (sum > s) {
                break;
            }
            i++;
            count++;
        }
        System.out.println(count);

    }
}
