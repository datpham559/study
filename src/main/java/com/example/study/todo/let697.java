package com.example.study.todo;

import java.util.HashMap;
import java.util.Map;

public class let697 {
    public static void main(String[] args) {
        System.out.println("result" + findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        Map<Integer, Integer> maxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            first.putIfAbsent(nums[i], i);
            last.put(nums[i], i);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > max){
                max = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == max){
                maxMap.put(entry.getKey(),entry.getValue());
            }
        }
        int min = Integer.MAX_VALUE;

        for (Integer set : maxMap.keySet()){
            int length = last.get(set) - first.get(set) + 1;
            if (length < min){
                min = length;
            }
        }
        return min;
    }
}
