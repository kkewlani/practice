/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 * 37.6K
 * 1.7K
 * Companies
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 *
 * leetcode link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringUniqueChars {

    public static String longestSubstringUniqChars(String str) {
        if(str == null || str.isEmpty()) {
            return  "";
        }
        int[] countTracker= new int[128];
        /*for (int c : str.toCharArray()) {
            countTracker[c]++;
        }*/
        int end=0, begin=0, counter=0, longStart=0, longLength=0;
        while(end<str.length()) {
            countTracker[str.charAt(end)]++;
            if(countTracker[str.charAt(end)]>1) {
                counter++;
            }
            end++;
            while(counter>0) {
                if(longLength < end-begin) {
                    longStart=begin;
                    longLength=end-begin;
                }
                countTracker[str.charAt(begin)]--;
                if(countTracker[str.charAt(begin)]==1){
                    counter--;
                }
                begin++;
                //System.out.println("end:"+end+",begin:"+begin);
            }
        }
        return str.substring(longStart, longStart+longLength-1);
    }

    public static void main(String[] args) {
        System.out.println("longest unique substring: "+longestSubstringUniqChars("pwwkew"));
    }
}
