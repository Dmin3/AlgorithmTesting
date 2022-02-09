package javaCodingTest.sorting_searching;

import java.util.Arrays;

public class MeetingRoom {
    public static void main(String[] args) {

        MeetingRoom a = new MeetingRoom();

//        int[][] intervals = {{5, 10}, {16, 20}, {0, 30}};
        int[][] intervals = {{6, 10}, {1, 3}};

        System.out.println(a.solve(intervals));


    }

    public boolean solve(int[][] intervals){
        if (intervals == null || intervals.length == 0){
            return false;
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); //x좌표 오름차순 정렬

        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end){
                return false;
            }
            end = intervals[i][1]; // end 시간
        }
        return true;
    }

}
