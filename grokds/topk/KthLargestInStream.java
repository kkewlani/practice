package topk;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class KthLargestInStream {

    //tracking min from all the K max elements
    PriorityQueue<Integer> minHeap ;
    public KthLargestInStream(int[] nums, int k) {

        minHeap = new PriorityQueue<>(k);
        IntStream.range(0,k).forEach(i-> minHeap.offer(nums[i]));
        IntStream.range(k,nums.length).forEach(i -> addNGetKthLargest(nums[i]));
    }

    private int addNGetKthLargest(int num) {
        if(minHeap.peek() < num) {
            minHeap.poll();
            minHeap.offer(num);
        }
        return minHeap.peek();
    }

    public int add(int num) {
        return addNGetKthLargest(num);
    }

}
