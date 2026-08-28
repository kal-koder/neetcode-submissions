class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> seen = new HashMap<>();
        seen.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int dual = target - nums[i];
            if (seen.containsKey(dual)) {
               // if (nums[i] < dual) {
                    return new int[] {seen.get(dual), i};
                //} else {
                //    return new int[] {seen.get(dual), i};
                //}
            }
            seen.put(nums[i],i);
        }
        return new int[] {0};
    }
}














