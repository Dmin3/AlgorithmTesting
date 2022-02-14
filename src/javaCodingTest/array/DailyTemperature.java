package javaCodingTest.array;

import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {

    DailyTemperature a = new DailyTemperature();
    int[] tem = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] results = a.solve_for(tem);
        for (int i : results) {
            System.out.print(i + " ");
        }
    }

    // stack을 이용한 풀이
    private int[] solve_for(int[] tem) {
        //ds
        int len = tem.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && tem[stack.peek()] < tem[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }


}
