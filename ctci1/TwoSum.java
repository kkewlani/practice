import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length<1 || target <0) {
            return new int[2];
        }

        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        int [] result = new int[2];
        for(int i =0; i<nums.length; i++) {
            List<Integer> indices = indexMap.getOrDefault(nums[i], new ArrayList<>());
            indices.add(i);
            indexMap.put(nums[i], indices);
        }
        

        for(int i =0; i<nums.length; i++) {
            int remainder = target-nums[i];
            List<Integer> indices = indexMap.getOrDefault(remainder, new ArrayList<Integer>());
            if(remainder == nums[i] && indices.size()>1) {
                result[0] = indices.get(0);
                result[1] = indices.get(1);
                break;
            } else if (indices.isEmpty()){
                continue;
            } else {
                int index = indices.get(0);
                if (i>index) {
                    result[0] = index;
                    result[1] = i;
                } else {
                    result[0] = i;
                    result[1] = index;
                }
            }
        }
        return result;
    }
}
