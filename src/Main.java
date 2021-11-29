import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();

      int sum = 1;

      for (int i = n; i > 0; i--){

          sum *= i;
      }
       if (n == 0){
           System.out.println(1);
       } else {
           System.out.println(sum);
       }










    }


}