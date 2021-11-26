import java.util.Scanner;

public class Number2747 {
    public static void main(String[] args) {

        int a=0;
        int b=1;
        int c=0;

        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        if(n == 1) {
            System.out.println(1);
        }else {
            for(int i=1; i<n; i++) {
                c=a+b;
                a=b;
                b=c;
            }
            System.out.println(c);
        }
    }
}
