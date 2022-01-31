import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number1546 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double max = Double.MIN_VALUE;

        double[] arr = new double[Integer.parseInt(br.readLine())];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        for (int i=0; i<arr.length; i++){
            arr[i] = Double.parseDouble(st.nextToken());
            if (arr[i] > max){
                max = arr[i];
            }
        }

        for (int i=0; i<arr.length; i++){
            sum += ((arr[i]/max) * 100);
        }
        System.out.println(sum / arr.length);


    }


}
