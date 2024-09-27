package topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.
 *
 */
public class RearrangeString {
    public String rearrangeStringSolution(String str) {

        if(str==null || str.isEmpty() || str.length()<1) {
          return str;
        }

        Map<Character, Integer> frequency = new HashMap<>();
        for(int i =0; i<str.length(); i++) {
            frequency.put(str.charAt(i), frequency.getOrDefault(str.charAt(i), 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxheap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        frequency.entrySet().forEach(maxheap::offer);

        if(str.length() < (maxheap.peek().getValue()*2 -1)) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        while(!maxheap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxheap.poll();
            IntStream.range(0, entry.getValue()).forEach(i -> {
                result.append(entry.getKey());
                if(!maxheap.isEmpty()) {
                    Map.Entry<Character, Integer> nextEntry = maxheap.poll();
                    result.append(nextEntry.getKey());
                    if(nextEntry.getValue()>1) {
                        nextEntry.setValue(nextEntry.getValue()-1);
                        maxheap.offer(nextEntry);
                    }
                }

            });
        }

        return result.toString();
    }

    public static void main(String[] args) {
        RearrangeString sol = new RearrangeString();
        System.out.println("Rearranged string: " +
                sol.rearrangeStringSolution("aappp"));
        System.out.println("Rearranged string: " +
                sol.rearrangeStringSolution("Programming"));
        System.out.println("Rearranged string: " +
                sol.rearrangeStringSolution("aapa"));
    }
}
