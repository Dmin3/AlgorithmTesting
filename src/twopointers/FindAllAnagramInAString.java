package twopointers;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramInAString {
    public static void main(String[] args) {
        String s = "bacdgabcda";
        String p = "abcd";
        System.out.println(solve(s, p));
    }

    private static List<Integer> solve(String s, String p) {
        //ds
        List<Integer> result = new ArrayList<>();

        //NPE
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }

        //고유 키 값 완성
        int[] pArr = new int[26]; // a-z
        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++; // [1,1,1,1,0,0,]
        }


        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int[] sArr = new int[26];
            for (int j = 0; j < p.length(); j++) {
                sArr[s.charAt(i+j) - 'a']++;
            }
            if (check(pArr, sArr)){
                result.add(i);
            }
        }



        return result;


    }

    private static boolean check(int[] pArr, int[] sArr) {
        for (int i = 0; i < pArr.length; i++) {
            if (pArr[i] != sArr[i]) {
                return false;
            }
        }
        return true;
    }
}
