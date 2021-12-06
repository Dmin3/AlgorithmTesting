import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Number2562 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<9; i++){
            int input = Integer.parseInt(br.readLine());
            list.add(i, input);
        }
        int max = 0;

        for (int i=0; i < list.size(); i++){

            if (max < list.get(i)){
                max = list.get(i);
            }

        }

        System.out.println(max);
        System.out.println(list.indexOf(max) + 1);




    }
}
