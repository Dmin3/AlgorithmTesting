package javaCodingTest.sorting_searching;

import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.Queue;

//K번 째 제일 큰 원소
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

//        int result = solve(nums, k);
//        System.out.println(result);

        int result = solve_pq(nums, k);
        System.out.println(result);
    }

    // HEAP 사용해서 풀어보기
    private static int solve_pq(int[] nums, int k) {

        Queue<Integer> pq = new PriorityQueue<>(); // default : asc, minHeap
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }


    // RANK 배열을 선언하여 사용해보기
    private static int solve(int[] nums, int k) {


        int[] ranks = new int[nums.length];
        for (int i=0; i < ranks.length; i++){
            ranks[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j){
                    continue;
                }
                if (nums[i] < nums[j]) {
                    ranks[i]++;
                }
            }
        }

        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i] == k){
                return nums[i];
            }
        }


       return -1;
    }


}
