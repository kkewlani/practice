package topk;

import java.util.*;
import java.util.stream.*;

public class TopKFrequentNumbers {

    public List<Integer> findTopKFrequentNumbers(int[] nums, int k) {

        if(nums==null || nums.length <1 || k< 1) {
            return new ArrayList<>();
        }

        HashMap<Integer, Integer> frequency = new HashMap<>();

        Arrays.stream(nums).forEach(n -> frequency.put(n, frequency.getOrDefault(n, 0) + 1));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(frequency::get));

        //IntStream.range(0, k).forEach(i -> minHeap.offer(nums[i]));

        frequency.forEach((key, value) -> {
            if(minHeap.size() < k) {
                minHeap.offer(key);
            } else if(frequency.get(minHeap.peek()) < value) {
                minHeap.poll();
                minHeap.offer(key);
            }
        });

        return new ArrayList<>(minHeap);
    }
}
