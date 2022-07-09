import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        List<Node> node = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            node.add(new Node(i, nums[i]));
        }

        node.sort(Comparator.comparingInt(o -> o.value));

        int lo = 0;
        int hi = nums.length - 1;

        while (true) {
            int sum = node.get(lo).value + node.get(hi).value;

            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                answer[0] = node.get(lo).index;
                answer[1] = node.get(hi).index;
                return answer;
            }

        }
    }
}
