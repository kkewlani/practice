package topk;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class KthSmallestNumber {
    public int findKthSmallestNumber(int[] nums, int k) {
        // Empty Array or k > array size or k < 1
        if(nums == null || nums.length < k || k < 1 ) {
            return 0;
        }

        // Max Heap to store k smallest numbers and max of those K on top
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (n1, n2) -> n2 - n1);

        // Add K elements in the maxHeap
        IntStream.range(0, k).forEach(i -> maxHeap.offer(nums[i]));

        IntStream.range(0, k).forEach(System.out::println);
        maxHeap.stream().forEach(System.out::println);
        // Update Max Heap if any array element is smaller than the largest in the heap
        IntStream.range(k, nums.length).forEach(i -> {
            if(maxHeap.peek()>nums[i]) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        });

        return maxHeap.peek();
    }
}
