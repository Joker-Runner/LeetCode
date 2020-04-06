package com.joker;

/**
 * 168. Excel Sheet Column Title
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 */
public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }

    public static String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            int mod = n % 26;
            if (mod == 0)
                n = n - 26;
            stringBuilder.insert(0, numToChar(mod));
            n = (n - mod) / 26;
        }
        return stringBuilder.toString();
    }


    private static char numToChar(int num) {
        if (num == 0) return 'Z';
        return (char) ('A' + num - 1);
    }


    /**
     * 优秀版本
     * @param n
     * @return
     */
    public String convertToTitleFasterVer(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}
