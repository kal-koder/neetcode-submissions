class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] res = new int[nums.length];
        Arrays.fill(res,1);
        res[0] = 1;
        res[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            res[i] = nums[i-1] *res[i-1];
        } 
            int k = 1; 
         for (int i = nums.length -2; i>=0; i--) {
            k *= nums[i+1];
            res[i] *=k;
        }
        return res;
    }
}  
