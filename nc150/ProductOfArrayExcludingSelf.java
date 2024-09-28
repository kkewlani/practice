/**
 * Products of Array Excluding Self
 * Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
 *
 * Each product is guaranteed to fit in a 32-bit integer.
 *
 * Follow-up: Could you solve it in
 * O
 * (
 * n
 * )
 * O(n) time without using the division operation?
 *
 * Example 1:
 *
 * Input: nums = [1,2,4,6]
 *
 * Output: [48,24,12,8]
 * Example 2:
 *
 * Input: nums = [-1,0,1,2,3]
 *
 * Output: [0,-6,0,0,0]
 * Constraints:
 *
 * 2 <= nums.length <= 1000
 * -20 <= nums[i] <= 20
 */

public class ProductOfArrayExcludingSelf {
    public int[] productExceptSelfV1(int[] nums) {

        int product = 1 ;
        int zCount = 0;
        for (int num : nums) {
            if(num==0) {
                zCount++;
                continue;
            }
            product *= num;
        }
        int[] output = new int[nums.length];
        if(zCount>1) {
            return output;
        }

        for (int i=0; i<nums.length; i++) {
            if(nums[i]==0) {
                output[i]=product;
            } else if(zCount>0) {
                output[i]=0;
            } else {
                output[i]=(product/nums[i]);
            }
        }
        return output;
    }

    // Runtime complexity O(n) - w/o division
    public int[] productExceptSelfV2(int[] nums) {

        int[] preProduct = new int[nums.length];
        int[] postProduct = new int[nums.length];
        int zCount=0;
        int preVal=1, postVal=1;
        int[] output = new int[nums.length];
        for(int i=0, k=nums.length-1; i< nums.length && k >=0; i++, k--) {
            // Taking care of zero count
            if(nums[i]==0) {
                zCount++;
            }
            if(zCount>1) {
                return output;
            }

            if(i==0 && k==nums.length-1) {
                preProduct[i]=preVal;
                postProduct[k]=postVal;
            } else {
                preProduct[i]= preVal;
                postProduct[k]= postVal;
            }
            preVal *= nums[i];
            postVal *= nums[k];

        }

        for(int i=0; i< nums.length ; i++) {
            output[i] = preProduct[i] * postProduct[i];
        }
        return output;
    }

    // V2 Simplified
    public int[] productExceptSelfV3(int[] nums) {
        int pre=1, post=1;
        int[] output = new int[nums.length];
        for(int i=0; i< nums.length; i++) {
            output[i] = pre;
            pre *=nums[i];
        }

        for(int k=nums.length-1; k >=0; k--) {
            output[k] *= post;
            post *=nums[k];
        }
        return output;
    }
}
