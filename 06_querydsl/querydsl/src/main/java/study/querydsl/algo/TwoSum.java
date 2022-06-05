package study.querydsl.algo;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

    }

    private static int[] solution(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (map.containsKey(target - num)) {
                int[] answer = new int[2];
                answer[0] = map.get(target = num);
                answer[1] = i;
                return answer;
            }
            map.put(num, i);
        }

        return null;
    }
}
