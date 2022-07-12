/*
[1, 1, 2, 3, 4],
[1, 2, 3, 4, 1]

[1, 1, 2, 6],

[24, 12, 4, 1]
*/


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        
        int[] revArr = new int[nums.length];
        
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = nums[i - 1] * arr[i - 1];
        }
        
        revArr[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            revArr[i] = nums[i + 1] * revArr[i + 1];
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i] * revArr[i];
        }
        
        return answer;
        
    }
}