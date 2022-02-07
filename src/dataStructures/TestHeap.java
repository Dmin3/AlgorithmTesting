package dataStructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestHeap {
    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 6, 1, 7};

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }
        heap.clear();

        System.out.println(Arrays.toString(arr)); // [7, 6, 4, 3, 2, 1]

    }
}
