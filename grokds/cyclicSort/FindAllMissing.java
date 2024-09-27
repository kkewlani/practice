package cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissing {
    public List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        int j = 0;
        //sort nums to put the values in their place
        while(j< nums.length) {
            // get correct index for the number at j
            int k = nums[j]-1;

            // swap the numbers if they are not same
            if(nums[j]!=nums[k]) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
            } else { // move forward in the array
                j++;
            }
        }

        // go over nums with elements in correct position to figure out the missing numbers
        for(int i=0; i < nums.length; i++) {
            if(nums[i]!=i+1) {
                missingNumbers.add(i+1);
            }
        }

        return missingNumbers;
    }
}
