import java.util.Scanner;

public class Number2439 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();

        for (int i =1; i<=t; i++){
            for (int j =0; j<t-i;j++){
                sb.append(' ');
            }
            for (int k=0; k<i; k++){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }
}
