import java.util.*;

/**
 * Top K Elements in List
 * Solved
 * Given an integer array nums and an integer k, return the k most frequent elements within the array.
 *
 * The test cases are generated such that the answer is always unique.
 *
 * You may return the output in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,3,3], k = 2
 *
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [7,7], k = 1
 *
 * Output: [7]
 * Constraints:
 *
 * 1 <= nums.length <= 10^4.
 * -1000 <= nums[i] <= 1000
 * 1 <= k <= number of distinct elements in nums.
 */

public class TopKElements {

    /*
     * Runtime Complexity for this one would be O(n log n)
     */
    public int[] topKFrequentV1(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Put all element in the Map for tracking frequency
        for(int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n,0)+1);
        }

        // put all map entries in PQ to sort in the order of their freuqency
        for (Map.Entry entry: freqMap.entrySet()) {
            maxHeap.offer(entry);
        }
        int[] result = new int[k];

        // retrieve top k elements till the Q runs out
        for(int i=0; i< k; i++) {
            if(!maxHeap.isEmpty()) {
                result[i] = maxHeap.poll().getKey();
            } else {
                break;
            }
        }

        return result;

    }

    // Runtime complexity of O(n)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // creating a list array to store the frequency as index
        // and corresponding nums in the list
        // Reverse indexing the freqMap - thus can have multiple values for a frequency
        List<Integer>[] freqArr = new List[nums.length+1];

        for(int i = 0; i< freqArr.length; i++) {
            freqArr[i] = new ArrayList<>();
        }

        // Put all element in the Map for tracking frequency
        for(int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n,0)+1);
        }

        // put all map entries in freqArr
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            freqArr[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];

        // iterate over the freqArr starting from back and fill result array
        // while there is an entry in freqArr and all k places in result are filled
        int rIndex = 0;
        for(int i=freqArr.length-1; i>0 && rIndex < k; i--) {
            // iterate over each freqArr entry ( if list not empty) to fill result
            for(int n : freqArr[i]) {
                result[rIndex] = n;
                rIndex++;
                if(rIndex==k) {
                    return result;
                }
            }
        }
        return result;

    }
}
