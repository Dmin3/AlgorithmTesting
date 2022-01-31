import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number4344 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());


        for (int i=0; i<C; i++){
            st = new StringTokenizer(br.readLine(), " ");

            //학생 수
            int num = Integer.parseInt(st.nextToken());

            double[] arr = new double[num];
            double sum= 0;

            for (int j=0; j < arr.length; j++){
                arr[j] = Double.parseDouble(st.nextToken());
                sum += arr[j];
            }

            double avg = sum / num;
            double cnt = 0;

            for (int k=0; k<arr.length;k++){
                if (arr[k] > avg){
                    cnt++;
                }
            }
            double result = (100 / (double) num) * cnt;
            sb.append(String.format("%.3f", result) + "%" + "\n");
        }


        System.out.println(sb);





    }
}
