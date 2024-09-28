import java.util.*;
/**
 *
 Longest Consecutive Sequence
 Given an array of integers nums, return the length of the longest consecutive sequence of elements.

 A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element.

 You must write an algorithm that runs in O(n) time.

 Example 1:

 Input: nums = [2,20,4,10,3,4,5]

 Output: 4
 Explanation: The longest consecutive sequence is [2, 3, 4, 5].

 Example 2:

 Input: nums = [0,3,2,5,4,6,1,1]

 Output: 7
 Constraints:

 0 <= nums.length <= 1000
 -10^9 <= nums[i] <= 10^9
 */
public class LongestConsecutiveSequence {
    /**
     * Set to track all the numbers in the input array
     * iterate over list and check if the consecutive numbers are in the set till it is not
     *
     * Runtime : n*(k+k-1+k-2...) = n*n = n^2 ---- O(n^2) where n is numbers in array and k is the maxLength that can be max n
     * Space: O(n)
     */
    public int longestConsecutiveV1(int[] nums) {
        if(nums==null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();

        for(int num : nums) {
            numSet.add(num);
        }

        int maxLen = 1;
        for(int i=0; i<nums.length; i++) {
            int currLen = 1;
            int nextVal = nums[i]+1;
            while(numSet.contains(nextVal)) {
                currLen++;
                nextVal +=1;
            }
            if(currLen>maxLen) {
                maxLen = currLen;
            }
        }
        return maxLen;
    }

    /**
     * Set to track all the numbers in the input array
     * iterate over list and check if the consecutive numbers are in the set till it is not
     *
     * Runtime : n*(k) = n*k = 2n ---- O(n) where n is numbers in array and k is the maxLength that can be max n
     * Space: O(n)
     */
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();

        for(int num : nums) {
            numSet.add(num);
        }

        int maxLen = 1;
        for(int i=0; i<nums.length; i++) {
            int currLen = 1;
            int nextVal = nums[i]+1;
            // Skipping if there is a previous element present in set -
            // thus should only consider the element for which there is no prev sequence element in the set,
            // so that the sequence is evaluated only once
            // This is important to get a O(n) runtime complexity
            if(numSet.contains(nums[i]-1)) {
                continue;
            }
            while(numSet.contains(nextVal)) {
                currLen++;
                nextVal +=1;
            }
            if(currLen>maxLen) {
                maxLen = currLen;
            }
        }
        return maxLen;
    }
}
