class Solution {

    public int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if (nums[lo] > nums[hi]) {
            return nums[hi];
        }

        return nums[lo];
    }
}
