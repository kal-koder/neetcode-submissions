class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> seen = new HashMap<>(nums.length);
       
        for (int i = 0; i < nums.length; i++) {
            int dual = target - nums[i];
            if (seen.containsKey(dual)) {

                    return new int[] {seen.get(dual), i};

            }
            seen.put(nums[i],i);
        }
        return new int[] {0};
    }
}














