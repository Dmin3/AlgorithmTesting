import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Number3052 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> value = new HashSet<>();

        for (int i=0; i<10;i++){
            int a = Integer.parseInt(br.readLine());
            int nmg = a % 42;
            value.add(nmg);
        }
        System.out.println(value.size());


    }
}
