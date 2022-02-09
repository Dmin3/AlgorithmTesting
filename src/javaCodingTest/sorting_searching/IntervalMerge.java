package javaCodingTest.sorting_searching;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntervalMerge {
    public static void main(String[] args) {

        IntervalMerge a = new IntervalMerge();

        int[][] intervals = {{1, 4}, {2, 6}, {8, 10}, {15, 18}};

        System.out.println(Arrays.deepToString(a.solve(intervals)));
        


    }

    private int[][] solve(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});


        return res.toArray(new int[res.size()][]);

    }
}
