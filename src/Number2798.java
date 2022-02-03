import java.util.Scanner;

public class Number2798 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }


        int max = 0;
        int temp = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    temp = arr[i] + arr[j] + arr[k];
                    if (temp <= M && max < temp){
                        max = temp;
                    }

                }
            }
        }
        System.out.println(max);


    }
}
