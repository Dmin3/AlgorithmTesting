import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Number1427 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        List<Long> list = new ArrayList<>();

        while (N != 0){

            long a = N % 10;

            list.add(a);

            N = N / 10;

        }
        Collections.sort(list, Collections.reverseOrder());

        for (Long result : list) {
            System.out.print(result);
        }





    }
}
