import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void groupingAnagrams(String[] words) {
        Map<String, List<String>> wordMapList = new HashMap<>();
        for (String word : words) {
            addWordToMap(wordMapList, word);
        }
        int i = 0;
        //keyset can be in any order but the output will give all anagrams grouped together
        for (String key : wordMapList.keySet()) {
            for (String word : wordMapList.get(key)) {
                words[i++] = word;
            }
        }
    }

    private static void addWordToMap(Map<String, List<String>> wordMapList, String word) {
        String sortedWord = getSortedAnagram(word);
        List<String> anagrams = wordMapList.get(sortedWord);
        if (anagrams == null) {
            anagrams = new ArrayList<>();
            wordMapList.put(sortedWord, anagrams);
        }
        anagrams.add(word);
    }

    //O(log W) where W is the wordSize
    private static String getSortedAnagram(String word) {
        char[] wordChars = word.toCharArray();
        Arrays.sort(wordChars);
        return String.valueOf(wordChars);
    }


    public static void main(String[] args) {
        String[] words =
                new String[]{"abb", "assas", "bab", "saa", "saas", "sabs", "aas", "sasa", "bbs", "sbb", "acre", "sbas",
                        "care", "ssasa", "bsb", "asass", "race"};
        groupingAnagrams(words);
        System.out.println("grouped anagrams:");
        Arrays.stream(words).forEach(System.out::println);
    }
}

