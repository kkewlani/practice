package cyclicSort;

public class FindMissingNumber {

    public int findMissingNumber(int[] nums) {
        sort(nums);

        for(int i=0; i< nums.length; i++) {
            if(nums[i]!=i) {
                return i;
            }
        }
        return nums.length;
    }
    private void sort(int[] nums) {
        if(nums==null || nums.length<2) {
            return;
        }
        int i = 0;
        while(i < nums.length) {
            int j = nums[i];

            if(j < nums.length && nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }
    }
}
