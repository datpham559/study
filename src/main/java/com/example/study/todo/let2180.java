package com.example.study.todo;

public class let2180 {

    public static void main(String[] args) {
        System.out.println("result" + countEven2(30));
    }

    public static int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0;
            for (Character c : Integer.toString(i).toCharArray()) {
                sum += Integer.parseInt(String.valueOf(c));
            }
            if (sum % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int countEven2(int num) {
        // 155 / 10 = 15 dư 5 -> 15 / 10 = 1 dư 5 -> 1 /10 = 0 dư 1
        // 15 + 1
        // 155/ 100 = 1 dư 55 -> 55/10 = 5 dư 5 -> 1 + 5 + 5

        return 0;
    }
}
