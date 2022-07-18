/*
- 0, length-1 로 비교해서 두개로 끊어줌
- 경계까지 끊어서 분할함
- 왼쪽이랑 오른쪽 분할시킴
- 왼쪽 돌리고 오른쪽 돌리기
- 왼쪽 오른쪽 다 값 못찾았으면 -1 리턴

 */

class Solution {

    public int findMiddleIndex(int lo, int hi, int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[hi] > nums[0]) {
            return nums[0];
        }

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid + 1] < nums[mid]) {
                return mid + 1;
            }

            if (nums[mid] < nums[mid - 1]) {
                return mid;
            }

            if (nums[mid] > nums[0]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return -1;
    }

    public int findTarget(int lo, int hi, int target, int[] nums) {

        lo--;
        hi++;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        if (nums[0] > nums[nums.length - 1]) {
            int middleIndex = findMiddleIndex(lo, hi, nums);
            int leftIndex = findTarget(0, middleIndex - 1, target, nums);
            int rightIndex = findTarget(middleIndex, nums.length - 1, target, nums);

            if (leftIndex == -1 && rightIndex == -1) {
                return -1;
            }

            if (leftIndex == -1) {
                return rightIndex;
            }
            return leftIndex;

        } else {
            return findTarget(lo, hi, target, nums);
        }
    }
}
