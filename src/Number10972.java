import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Number10972 {
    /**
     * Next Permutation
     */
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] integers = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, Collections.reverseOrder());
        int[] check = Arrays.stream(integers).mapToInt(i -> i).toArray();

        boolean isSame = true;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]!= check[i]) {
                isSame = false;
                break;
            } else {
                continue;
            }
        }

        if (isSame){
            System.out.println(-1);
        } else {
            permutation(arr);
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }
    }

    public static void permutation(int[] nums) {
        // 뒤에서부터 오름차순이 깨지는 인덱스 확인(a)
        int a = nums.length - 2;

        while (a >= 0 && nums[a] >= nums[a+1]) a--;

        if (a != -1) {
            // 뒤에서부터 탐색하면서 a 보다 더 큰 첫번째 인덱스 확인(b)
            int b = nums.length - 1;
            while (nums[a] >= nums[b]) b--;
            //a랑b 스왑
            swap(nums, a, b);
        }

        // a+1 부터 끝까지 오름차순 정렬
        int start = a + 1;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
