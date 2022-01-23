import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number10808 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열 0으로 초기화
        int[] arr = new int[26];
        for (int i =0; i < arr.length; i++){
            arr[i] = 0;
        }
        // 입력
        String str = br.readLine();


        for (int i=0; i <str.length(); i++){
            int count = 0;
            char ch = str.charAt(i);
            if (arr[ch - 'a'] == 0){
                for (int j=0; j< str.length(); j++){
                    if (ch == str.charAt(j)){
                        count++;
                    }
                }
                arr[ch - 'a'] = count;

            }
        }
        for (int val: arr) {
            System.out.print(val + " ");
        }


    }
}
