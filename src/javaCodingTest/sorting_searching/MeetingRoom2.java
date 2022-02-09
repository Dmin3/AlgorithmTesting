package javaCodingTest.sorting_searching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {
    public static void main(String[] args) {

        MeetingRoom2 a = new MeetingRoom2();

       int[][] intervals = {{5, 10}, {16, 20}, {0, 30}};
//        int[][] intervals = {{6, 10}, {1, 3}};


       System.out.println(a.solve(intervals));


    }

    public int solve(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); //asc
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int[] arr : intervals) {
            if (q.isEmpty()) {
                q.offer(arr);
            } else {
                if (q.peek()[1] <= arr[0]) {
                    q.poll();
                }
                q.offer(arr);
            }
        }

        return q.size();
    }
}
