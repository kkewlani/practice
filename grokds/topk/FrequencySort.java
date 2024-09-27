package topk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.*;

public class FrequencySort {
    public String sortCharacterByFrequency(String str) {
        if(str==null || str.isEmpty() || str.length()<2) {
            return str;
        }

        HashMap<Character, Integer>  frequency = new HashMap<>();
        for(int i =0; i < str.length(); i++) {
            // consider uppercase and lower case as same
            //frequency.put(Character.toLowerCase(str.charAt(i)), frequency.getOrDefault(Character.toLowerCase(str.charAt(i)), 0)+1);
            //consider uppercase and lowercase different
            frequency.put(str.charAt(i), frequency.getOrDefault(str.charAt(i), 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue()-e1.getValue());

        frequency.entrySet().stream().forEach(maxHeap::offer);
        StringBuilder result = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            IntStream.range(0, entry.getValue()).forEach(i -> result.append(entry.getKey()));
        }

        return result.toString();
    }
}
