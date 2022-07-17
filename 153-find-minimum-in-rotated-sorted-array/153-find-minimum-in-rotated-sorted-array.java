/*
return:
idea: n번 까지 돌릴 수 있으면 그냥 최솟값 찾으면 되는것 같은데 .. ?
log n에 풀어야 하고, 정렬 시킬수는 없음
정렬 안시키고 이분탐색 가능할 것 같음
how:
- 이분 탐색으로 lo < hi 인 지점까지 탐색
- hi 선택

*/

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;

        if (nums[right] > nums[0]) {
            return nums[0];
        }

        while (left + 1 < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[left] > nums[right]) {
            return nums[right];
        }
        return nums[left];
    }
}
