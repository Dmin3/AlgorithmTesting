package twopointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDistinct {
    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println(solve_map(s));
    }

    //map
    private static int solve_map(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int l=0, r=0, count=0, max =0;

        while (r < s.length()) {
            char c = s.charAt(r); //ccaabbb
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                count++;
            }
            r++;

            while (count > 2) {
                char c2 = s.charAt(l);
                map.put(c2, map.get(c2) - 1);
                if (map.get(c2) == 0) {
                    count--;
                }
                l++;
            }

            max = Math.max(max, r - l);

        }

        return max;

    }
}
