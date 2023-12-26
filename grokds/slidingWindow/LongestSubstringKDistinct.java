package slidingWindow;

import java.util.HashMap;

public class LongestSubstringKDistinct {
    public int findLength(String str, int k) {
        if(str==null ||str.isEmpty() || k > str.length()) {
            return 0;
        }
        int maxLength = 0;
        HashMap<Character, Integer> charCount = new HashMap<>();
        int windowStart=0;
        for(int windowEnd=0; windowEnd<str.length(); windowEnd++) {
            char curr = str.charAt(windowEnd);
            charCount.put(curr, charCount.getOrDefault(curr, 0)+1);

            while(charCount.size()>k) {

                //reduce frequency and if 0 then remove from map
                char firstChar = str.charAt(windowStart);
                int firstCharFreq = charCount.get(firstChar);
                if(firstCharFreq-1 == 0) {
                    charCount.remove(firstChar);
                } else {
                    charCount.put(firstChar, firstCharFreq-1);
                }

                windowStart++;
            }

            if(charCount.size()==k) {
                maxLength = Math.max(maxLength, windowEnd-windowStart+1);
            }
        }
        return maxLength;
    }
}
