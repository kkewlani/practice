/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 *
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 * link: https://leetcode.com/problems/sort-colors/description/
 */
public class SortColors {

    /**
     * Red =0, white =1, blue = 2;
     * We will use red,white and blue as pointers.
     * @param nums
     */
    public static void sortColors(int[] nums) {
        if(nums==null || nums.length==0) {
            return;
        }

        int index=0, red=0, blue=nums.length;
        /**
         * Strategy:
         * index is used to process the whoel array
         * red is tracking the index of Red (0) in the array from left -> right
         * blue is tracking the index of Blue (2) in the array from right <-left
         */
        while(index<=blue) {
            if(nums[index]==0) {
               nums[index]=nums[red];
               nums[red]=0;
               red++;
               // no reprocess needed after swap as red will either point to start index of white (1)
                // when index has moved forward then red if not then they both are moving together already
            }
            if(nums[index]==2) {
                nums[index]=nums[blue];
                nums[blue]=2;
                blue--;
                // to reprocess post swapping
                index--;
            }
            index++;
        }
    }
}
