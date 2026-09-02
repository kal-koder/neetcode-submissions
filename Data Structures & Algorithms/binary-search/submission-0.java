class Solution {
    public int search(int[] nums, int target) {
        int h = nums.length -1;
        int l = 0;
        while (l <= h) {
            int mid = (l+h) /2;
            if (nums[mid]==target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid +1;
                continue;
            }
            if (nums[mid] > target) {
                h = mid -1;
                continue;
            }
        }
        return -1;
    }
}
