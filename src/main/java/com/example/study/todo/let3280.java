package com.example.study.todo;

public class let3280 {
    public static void main(String[] args) {
        String a = convertDateToBinary("2080-02-29");
        System.out.println("result: " + a);

        String b = convertDateToBinary2("2080-02-29");
        System.out.println("result: " + b);
    }
    public static String convertDateToBinary(String date) {
        String[] split = date.split("-");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            Integer num = Integer.parseInt(split[i]);
            int temp = sb.length();
            while(num > 0) {
                sb.insert(temp,num % 2);
                num /= 2;
                // chia ra 4321 -> insert 1234
            }
            if (i != split.length - 1) {
                sb.insert(sb.length(),"-");
            }
        }
        return sb.toString();
    }
    public static String convertDateToBinary2(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8, 10));
        StringBuilder sb = new StringBuilder();
        int temp = sb.length();
        while (year > 0) {
            sb.insert(temp,year%2);
            year /= 2;
        }
        sb.insert(sb.length(),"-");
        temp = sb.length();
        while (month > 0) {
            sb.insert(temp,month%2);
            month /= 2;
        }
        sb.insert(sb.length(),"-");
        temp = sb.length();
        while (day > 0) {
            sb.insert(temp,day%2);
            day /= 2;
        }
        return sb.toString();
    }
}
