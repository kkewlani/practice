package cyclicSort;

public class FindDuplicateNumber {
    public int findNumber(int[] nums) {
        int duplicateNum = -1;
        if(nums==null || nums.length == 0) {
            return duplicateNum;
        }
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
                duplicateNum = nums[i];
                break;
            }
        }

        return duplicateNum;
    }


    // In O(1) space w/o modifying the array
    // using two pointers
    public int findNumber2(int[] nums) {
        int duplicateNum = -1;
        if (nums == null || nums.length == 0) {
            return duplicateNum;
        }
        int j = 0;

        int slow = nums[j] - 1;
        int fast = nums[nums[slow] - 1];

        //sort nums to put the values in their place
        while (nums[slow] != nums[fast]) {
            slow = nums[slow] - 1;
            fast = nums[nums[fast] - 1] - 1;
            // get correct index for the number at j

            int k = nums[j] - 1;

            // swap the numbers if they are not same
            if (nums[j] != nums[k]) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
            } else { // move forward in the array
                j++;
            }
        }

        // go over nums with elements in correct position to figure out the missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                duplicateNum = nums[i];
                break;
            }
        }

        return duplicateNum;
    }
}
