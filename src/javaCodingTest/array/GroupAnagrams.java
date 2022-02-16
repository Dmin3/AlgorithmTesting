package javaCodingTest.array;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solve(list));


    }

    private static List<List<String>> solve(String[] str) {
        // ds
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String s : str) {
            int[] cnt = new int[26]; // a-z

            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(cnt);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                result.add(entry.getValue());
            }
        return result;
    }
}
