import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int minSetPrice = Integer.MAX_VALUE;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int setPrice = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            minSetPrice = Math.min(setPrice, minSetPrice);
            minPrice = Math.min(minPrice, price);

        }

        int sum = 0;
        while (n > 0) {
            //세트보다 낱개가 비싸면 세트로 먼저 계산
            if (minPrice > minSetPrice) {
                sum += minSetPrice;
                n = n - 6;
            } else if (n >= 6) {
                if (minSetPrice < minPrice * 6) { // 낱개 * 6 이 세트보다 비싸면 세트로 계산
                    sum += minSetPrice;
                } else {
                    sum += minPrice * 6;
                }
                n = n - 6;
            } else if (n < 6){
                if (minSetPrice > minPrice * n){
                    sum += minPrice * n;
                } else {
                    sum += minSetPrice;
                }
                n = 0;
            }
        }

        System.out.println(sum);
    }
}
