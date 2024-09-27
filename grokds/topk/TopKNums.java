package topk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an unsorted array of numbers, find the ‘K’ largest numbers in it
 */
public class TopKNums {
    public List<Integer> findKLargestNumbers(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        if (k==0 || nums==null || nums.length==0) {
            return result;
        }
        // Min heap to keep track of the K largest elements with min of all K as the top element
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, (n1, n2) -> n1 - n2);

        for (int i =0; i<k; i++) {
            minHeap.add(nums[i]);
        }

        // compare the min of the K largest elements to be replaced by anything larger than the min of K
        for (int i=k; i<nums.length; i++) {
            if(nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return new ArrayList<>(minHeap);
    }
}
