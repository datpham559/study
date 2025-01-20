package com.example.study.todo;

import java.util.HashMap;
import java.util.Map;

public class mai {
//    public static void main(String[] args) {
//        int[] nums = {1,3,5,6};
//        int a = searchInsert(nums,2);
//
//        System.out.println(a);
//    }

    public static int searchInsert(int[] nums, int target) {
        int index = nums.length / 2;
        int ix = 0;
        if (nums[index] == target) {
            return index;
        } else if (nums[index] > target) {
            for (int i = 0; i < index; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            for (int i = 0; i < index; i++) {
                if (nums[i] > target) {
                    ix = i + 1;
                }
            }
            return ix;
        } else {
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            for (int i = index + 1; i < nums.length; i++) {
                if (target > nums[i]) {
                    ix = i + 1;
                }
            }
            return ix;
        }
    }

    public static void main(String[] args) {
        int a = maxNumberOfBalloons("leetcode");

        System.out.println(a);
    }


    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);
        for (Character c : text.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
        }
        return Math.min(Math.min(map.get('l')/2, map.get('o')/2), Math.min(Math.min(map.get('a'), map.get('b')), map.get('n')));
    }
}
