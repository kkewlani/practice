import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 *
 * link: https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {

    public static int countSubstringsSolution1(String str) {
        if(str==null || str.isEmpty()) {
            return 0;
        }
        int palinCount = 0;
        int windowSize=1, possibleSubStrings, start, end;

        while(windowSize<str.length()) {
            possibleSubStrings = str.length()-windowSize + 1;
            start=0;
            end=windowSize-1;
            while(possibleSubStrings>0 && end<str.length()) {
                if(checkPalindrome(str, start, end)){
                    palinCount++;
                }
                start++;
                end++;
                possibleSubStrings--;
            }
            windowSize++;
        }
        return palinCount;
    }

    public static int countSubstringsSolution2(String str) {
        if(str==null || str.isEmpty()) {
            return 0;
        }
        HashSet<String> palinStrings = new HashSet<>();
        int palinCount = 0;
        int windowSize=1, possibleSubStrings, start, end;

        while(windowSize<=str.length()) {
            possibleSubStrings = str.length()-windowSize + 1;
            start=0;
            end=windowSize-1;
            while(possibleSubStrings>0 && end<str.length()) {
                String substr = str.substring(start,end+1);
                if(palinStrings.contains(substr)){
                    palinCount++;
                } else if(checkPalindrome(substr)){
                    palinStrings.add(substr);
                    palinCount++;
                }
                start++;
                end++;
                possibleSubStrings--;
            }
            windowSize++;
        }
        return palinCount;
    }

    private static boolean checkPalindrome(String str) {
        return checkPalindrome(str, 0, str.length()-1);
    }
    private static boolean checkPalindrome(String str, int start, int end) {
        if(str==null || str.isEmpty()) {
            return false;
        }
        int i=start, j=end;
        while(i<j) {
            if(str.charAt(i)==str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static int countSubstrings(String str) {
        if(str==null || str.isEmpty()) {
            return 0;
        }
        int count=0;
        for(int i=0; i<str.length();i++){
            count+= countPalindromes(str, i, i) + countPalindromes(str, i,i+1);
        }
        return count;
    }

    private static int countPalindromes(String str, int start, int end) {
        if(str==null || str.isEmpty()) {
            return 0;
        }

        int count=0;
        while(start>=0 && end<str.length()) {
            if(str.charAt(start)==str.charAt(end)) {
                count++;
            } else {
                break;
            }
            start--;
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("palindrome count:"+countSubstrings("abbabbaba"));
    }


}
