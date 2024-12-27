package easy;

/**
 * 1071. Greatest Common Divisor of Strings
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 * <p>
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 * <p>
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 * <p>
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */
public class GcdOfStrings {
    public String gcdOfStringsV1(String str1, String str2) {

        //Find possible divisors of str1
        // 0 - edge
        // 1 - 1
        // 2 - 1, 2
        // 3 - 1, 3
        // 4 - 1, 2, 4
        // 5 - 1, 5
        // 6 - 1, 2, 3, 6
        int i = Math.max(str1.length(), str2.length());
        while (i > 0) {
            if (str1.length() % i == 0 && str2.length() % i == 0) {
                if (verifyPattern(str1, i) && verifyPattern(str2, i)) {
                    String divisor = str1.substring(0, i);
                    if (divisor.equals(str2.substring(0, i))) {
                        return divisor;
                    }
                }
            }
            i--;
        }

        return "";

    }

    private boolean verifyPattern(String str1, int offset) {
        for (int i = 0; i < str1.length() && offset < str1.length(); i++) {
            int j = i;
            while ((j + offset) < str1.length()) {
                if (str1.charAt(j) != str1.charAt(j + offset)) {
                    return false;
                }
                j = j + offset;
            }
        }
        return true;
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdNum = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdNum);
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
