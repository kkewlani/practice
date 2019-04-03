// Runtime Complexity - O(n + n + k) = O(n)
// Space complexity - O(n)

class TwoSumByMovingInward {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length <=1) {
            return new int[0];
        }
        //(value, list(index))
        HashMap<Integer, List<Integer>> valueIndexMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if(valueIndexMap.containsKey(nums[i])) {
                valueIndexMap.get(nums[i]).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                valueIndexMap.put(nums[i], l);
            }
        }
        for (int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if(valueIndexMap.containsKey(diff)) {
                List<Integer> l = valueIndexMap.get(diff);
                int secondIndex = -1;
                for (Integer idx: l) {
                    if (i != idx) {
                        secondIndex = idx;
                        break;
                    }
                }
                if(secondIndex == -1) {
                    continue;
                }
                int[] indices = new int[2];
                indices[0] = i;
                indices[1] = secondIndex;
                return indices;
            }
        }
        return new int[0];
    }

}