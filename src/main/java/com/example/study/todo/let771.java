package com.example.study.todo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class let771 {
    /**
     You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
     Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
     Letters are case sensitive, so "a" is considered a different type of stone from "A".
     Example 1:

     Input: jewels = "aA", stones = "aAAbbbb"
     Output: 3
     Example 2:

     Input: jewels = "z", stones = "ZZ"
     Output: 0
     -> có jewels và stones, tìm trong stones xem có bao nhiêu viên là đá quý, ví dụ 1 là 3 bởi vì aAA đều có trong jewels
     */

    public static void main(String[] args) {
        System.out.println("result" + numJewelsInStones2("aA", "aAAbbbb"));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (Character c : stones.toCharArray()) {
            if (jewels.contains(c.toString())) {
                count++;
            }
        }
        return count;
    }
    public static int numJewelsInStones2(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        int count = 0;
        for (Character j : jewels.toCharArray()) {
            jewelSet.add(j);
        }
        for (Character c : stones.toCharArray()) {
            if (!jewelSet.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
