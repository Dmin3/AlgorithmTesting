import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number1157 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] arr = new int[26]; //알파벳 개수

        for (int i=0; i < s.length(); i++){
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z'){
                arr[s.charAt(i) - 'A']++;
            } else {
                arr[s.charAt(i) - 'a']++;
            }
        }

        int max = -1;
        char ch = '?';

        for (int i=0; i < 26; i++){
            if (max < arr[i]){
                max = arr[i];
                ch = (char) (i + 65); // 대문자로 변경
            } else if(max == arr[i]){
                ch = '?';
            }
        }

        System.out.println(ch);



    }
}
