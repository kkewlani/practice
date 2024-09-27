package cyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FirstKMissingPositive {

    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        if(nums==null || nums.length==0) {
            int i = 1;
            while(i<=k) {
                missingNumbers.add(i);
                i++;
            }
            return missingNumbers;
        }

        int i =0;
        //put the numbers in their appropriate position
        while(i<nums.length) {
            int j = nums[i]-1;

            //swap
            if(j>=0 && j<nums.length && nums[i]!=nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        // Track the numbers in not-matching position to be used for check while filling k elements post array traversal
        HashSet<Integer> extraNums = new HashSet<>();
        //iterate over array to get the k missing positive
        // if the output list == k break and return result
        for(int l =0; l<nums.length && missingNumbers.size() < k ;l++) {
            if(nums[l]!=l+1) {
                missingNumbers.add(l+1);
                extraNums.add(nums[l]);
            }
        }

        // if output list< k add numbers starting from array length till k elements are filled
        int nextEle = nums.length+1;
        while(missingNumbers.size()<k) {
            if(!extraNums.contains(nextEle)) {
                missingNumbers.add(nextEle);
            }
            nextEle++;
        }

        return missingNumbers;
    }
}
