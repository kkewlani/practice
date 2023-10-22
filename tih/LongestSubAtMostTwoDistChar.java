import java.util.HashMap;

/**
 * Copied logic from here: https://leetcode.com/problems/minimum-window-substring/solutions/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems/
 * to learn the concept
 */
public class LongestSubAtMostTwoDistChar {

    public static int getLongestSubAtMostTwoDistChar(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }
        int counter = 0, end = 0, begin = 0, maxLen = 0;
        int[] countMap = new int[128];

        while(end < str.length()) {
            // keep moving forward till we get 3 unique chars and keep track of char count
            if(countMap[str.charAt(end)]==0) {
                counter++;
            }
            countMap[str.charAt(end)]++;
            end++;

            //keep moving forward till we have only 2 distinct chars by reducing char count
            while(counter>2) {
                if(countMap[str.charAt(begin)]==1) {
                    counter--;
                }
                countMap[str.charAt(begin)]--;
                begin++;
            }
            maxLen = Math.max(maxLen, end-begin);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(getLongestSubAtMostTwoDistChar(null));
    }
}
