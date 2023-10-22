/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window.
 *  If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 * link: https://leetcode.com/problems/minimum-window-substring/description/
 */
public class MinWindowSubstring {
    public static String minWindow(String baseStr, String searchStr) {
        if(baseStr==null || baseStr.isEmpty() || searchStr==null || searchStr.isEmpty()) {
            return "Invalid Input";
        }
        // Map to keep track of occurrence count of char in searchStr
        int[] ssCountMap = new int[128];
        for(int c: searchStr.toCharArray()) {
            ssCountMap[c]++;
        }
        // begin and end will use to manage moving window
        // counter tracks character count of searchStr in the window, 0 => all chars in window, >0 => missing in window
        // minStart and minLength to track the result window and for comparison to find lowest
        int end=0, begin=0, counter=searchStr.length(), minStart=0, minLength=Integer.MAX_VALUE;

        // start moving forward and check the char in searchStr
        // if it exists then reduce counter by 1 and reduce count in tracker Map (char level). -ve => more than needed char encountered
        // keep moving forward till all searchStr chars are found aka trackerMap entries for all searchStr chars are 0 and counter is also 0
        while(end<baseStr.length()) {
            if(ssCountMap[baseStr.charAt(end)]>0) {
                counter--;
            }
            ssCountMap[baseStr.charAt(end)]--;
            end++;
            // when counter is 0 => all chars in searchstr are found
            // compare minLength and record if any changes
            // move the left window cursor forward and updating trackerMap by incrementing for those chars
            while(counter==0) {
                if(minLength > (end-begin)) {
                    minStart = begin;
                    minLength = end-begin;
                }
                ssCountMap[baseStr.charAt(begin)]++;
                //if any searchStr char being moved on from then deduce from counter so that it keep looking further
                if(ssCountMap[baseStr.charAt(begin)] > 0) {
                    counter++;
                }
                begin++;
            }
        }
        if (minLength!=Integer.MAX_VALUE) {
            return baseStr.substring(minStart, minStart+minLength);
        }
        return "No Solution";
    }

    public static void main(String[] args) {
        System.out.println(minWindow("akjhfndlkasndihelfsncjdjhchEHFJSNDNAKBDNVA", "jB"));

    }
}
