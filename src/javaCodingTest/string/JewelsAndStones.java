package javaCodingTest.string;

import java.util.HashSet;
import java.util.Set;

// 보석과 돌
public class JewelsAndStones {
    public static void main(String[] args) {
        String jewel = "aA";
        String stones = "aAABBB";

        System.out.println(solve(jewel, stones));


    }

    private static int solve(String jew, String stones) {

        Set<Character> set = new HashSet<>();
        char[] jewArr = jew.toCharArray();
        for (int i = 0; i < jewArr.length; i++) {
            set.add(jewArr[i]); // a , A
        }

        char[] stonseArr = stones.toCharArray();
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stonseArr[i])) {
                count++;
            }
        }
        return count;


    }

}
