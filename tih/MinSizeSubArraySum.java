/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 * link: https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinSizeSubArraySum {

    public static int minSubArrayLenSol1(int target, int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        int end=0, begin=0, runningSum=0, minLength=Integer.MAX_VALUE;

        while(begin<=end) {
            if(runningSum>=target) {
                //record the length
                if(minLength>(end-begin)) {
                    minLength = end-begin;
                }

                //move begin cursor forward to find other possibilities
                runningSum-=nums[begin];
                begin++;
            } else if (end<nums.length) {
                runningSum+=nums[end];
                end++;
            } else {
                break;
            }
        }
        return minLength==Integer.MAX_VALUE ? 0: minLength;
    }

    public static int minSubArrayLenSol2(int target, int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        int end=0, begin=0, runningSum=0, minLength=Integer.MAX_VALUE;
        while(end<nums.length) {
            runningSum+=nums[end];
            end++;

            while(runningSum >= target) {
                minLength = Math.min(minLength, end-begin);
                runningSum-=nums[begin];
                begin++;
            }
        }
        return minLength==Integer.MAX_VALUE ? 0: minLength;
    }

    public static void main(String[] args) {
        System.out.println("length:"+minSubArrayLenSol2(7, new int[]{2,3,1,2,4,3}));
    }
}
