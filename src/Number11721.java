import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;

public class Number11721 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        char[] arr = new char[s.length()];

        for (int i=0; i < arr.length; i++){
            arr[i] = s.charAt(i);
        }
        for (int i=0; i < arr.length; i++){
            if (i % 10 == 0 && i != 0){
                System.out.println();
            }
            System.out.print(arr[i]);
        }




    }
}
