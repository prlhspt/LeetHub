/*
[1, 1, 2, 3, 4],
[1, 2, 3, 4, 1]

[1, 1, 2, 6],

[24, 12, 4, 1]
*/


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }

        return result;
        
    }
}