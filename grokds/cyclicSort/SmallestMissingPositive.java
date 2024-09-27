package cyclicSort;

public class SmallestMissingPositive {
    public int findNumber(int[] nums) {
        int missingPosNum = -1;
        if(nums==null || nums.length==0) {
            return missingPosNum;
        }

        int i =0;
        while(i<nums.length) {
            int j = nums[i]-1;

            // swap if the element ideal pos is within the array
            if(j>=0 && j<nums.length && nums[i]!=nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        missingPosNum = nums.length+1;
        for(int k=0;k<nums.length;k++) {
            if(nums[k]!=k+1) {
                missingPosNum = k+1;
                break;
            }
        }
        return missingPosNum;
    }
}
