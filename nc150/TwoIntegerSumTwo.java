/**
 * https://neetcode.io/problems/two-integer-sum-ii
 * 
 * Given an array of integers numbers that is sorted in non-decreasing order.
 *
 * Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
 *
 * There will always be exactly one valid solution.
 *
 * Your solution must use
 * O
 * (
 * 1
 * )
 * O(1) additional space.
 *
 * Example 1:
 *
 * Input: numbers = [1,2,3,4], target = 3
 *
 * Output: [1,2]
 * Explanation:
 * The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1, index2 = 2. We return [1, 2].
 *
 * Constraints:
 *
 * 2 <= numbers.length <= 1000
 * -1000 <= numbers[i] <= 1000
 * -1000 <= target <= 1000
 */
public class TwoIntegerSumTwo {
    /**
     * diff being used for comparison purpose
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];
        if(numbers == null || numbers.length<2) {
            return output;
        }
        int start = 0;
        int end = numbers.length-1;


        int diff = 0;
        while(start<end) {
            diff = target - numbers[end];
            if(diff == numbers[start]) {
                output[0] = start+1;
                output[1] = end+1;
                break;
            } else if(diff < numbers[start]) {
                end--;
            } else {
                start++;
            }
        }
        return output;
    }

    /**
     * From NC: curSum is being compared
     */
    public int[] twoSumV2(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int curSum = numbers[l] + numbers[r];

            if (curSum > target) {
                r--;
            } else if (curSum < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }

        return new int[0];
    }
}
}
