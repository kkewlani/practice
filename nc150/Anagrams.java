import java.util.*;
import java.util.stream.*;

/**
 * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
 *
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * Example 1:
 *
 * Input: strs = ["act","pots","tops","cat","stop","hat"]
 *
 * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
 * Example 2:
 *
 * Input: strs = ["x"]
 *
 * Output: [["x"]]
 * Example 3:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 */
public class Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagrams = new HashMap<>();
        for(String str : strs) {
            String sortedStr = sortChars(str);
            List<String> words = anagrams.getOrDefault(sortedStr, new ArrayList<>());
            words.add(str);
            anagrams.put(sortedStr, words);
        }

        return anagrams.values().stream().collect(Collectors.toList());
    }

    private String sortChars(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
