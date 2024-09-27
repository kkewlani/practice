package cyclicSort;

public class CyclicSort {

    public int[] sort(int[] nums) {
        if(nums==null || nums.length<2) {
            return nums;
        }
        int i = 0;
        while(i < nums.length) {
            int j = nums[i]-1;

            if(nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }
        return nums;
    }


}
