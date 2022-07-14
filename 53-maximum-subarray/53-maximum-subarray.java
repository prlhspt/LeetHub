class Solution {
    public int maxSubArray(int[] nums) {
        int N = nums.length;
        if(N == 0) return 0;
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int j = 0; j<N; j++){
            curr += nums[j];
            max=Math.max(curr, max);
            if(curr <= 0){
                curr = 0;
            }
        }

        return max;
    }
}