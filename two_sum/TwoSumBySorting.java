// Runtime Complexity - O(n + n log n + n + k) = O(n log n)
// Space complexity - O(n)

class TwoSumBySorting {
    public int[] twoSum(
            int[] nums,
            int target) {
        if (nums.length <= 1) {
            return new int[0];
        }
        HashMap<Integer, List<Integer>> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valueIndexMap.containsKey(nums[i])) {
                valueIndexMap.get(nums[i]).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                valueIndexMap.put(nums[i], l);
            }
        }
        Arrays.sort(nums);
        int arrLength = nums.length;
        int lhs = 0;
        int rhs = arrLength - 1;
        int sum = 0;
        while (lhs < rhs) {
            sum = nums[lhs] + nums[rhs];
            if (sum == target) {
                int[] indices = new int[2];
                List<Integer> lhsList = valueIndexMap.get(nums[lhs]);
                if (nums[lhs] == nums[rhs]) {
                    indices[0] = lhsList.get(0);
                    indices[1] = lhsList.get(1);
                } else {
                    indices[0] = lhsList.get(0);
                    List<Integer> rhsList = valueIndexMap.get(nums[rhs]);
                    indices[1] = rhsList.get(0);
                }
                return indices;
            } else if (sum < target) {
                lhs++;
            } else if (sum > target) {
                rhs--;
            }
        }
        return new int[0];
    }
}