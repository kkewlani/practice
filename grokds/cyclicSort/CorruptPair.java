package cyclicSort;

public class CorruptPair {
    public int[] findNumbers(int[] nums) {
        int[] corruptPair = new int[] { -1, -1 };
        if(nums==null || nums.length==0) {
            return corruptPair;
        }

        int i =0;
        //sort the elements to their appropriate position
        while(i < nums.length) {
            int j = nums[i]-1;

            if(nums[i]!=nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        // iterate through all elements and figure out the corrupt pair
        for(int k=0; k<nums.length; k++) {
            if(nums[k]!=k+1) {
                corruptPair[0] = nums[k];
                corruptPair[1] = k+1;
            }
        }
        return corruptPair;
    }
}
