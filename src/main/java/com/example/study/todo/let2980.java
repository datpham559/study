package com.example.study.todo;

import java.util.HashSet;
import java.util.Set;

public class let2980 {
    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5};
        int[] a = {2, 2};
        System.out.println("result " + hasTrailingZeros(a));
    }

    // cách này quá lâu, O(n*n)
    public static boolean hasTrailingZeros(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num = nums[i] | nums[j];
                if (num % 2 == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasTrailingZeros2(int[] nums) {
        // Bitwise with OR : Only 0 | 0 = 0 -> when array have 2 element num[i] % 2 == 0  -> 0 | 0 = 0 -> true
        // nếu mà cái cuối or = 0 mà có 2 phần tử trở lên = 0 thì khi or với nhau nó cũng = 0 => bắc cầu
        // 0R: 0 * 0 bằng 0 còn lại bằng 1
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) { // => 6 = 110
                count++;
            }
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}
