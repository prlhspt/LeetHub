/*
산 다음에만 팔 수 있음
무조건 최댓값을 고르는게 답이 아님

예제
[7,1,3] = 2
[5,6,1,4] = 3 (1, 4)

일단 차이값 갱신하고, 작아지면 min 값 갱신하기, 커지면 차이값 갱신하기

*/

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int difference = 0;
        
        for (int i = 0; i < prices.length - 1; i++) {
            if (min > prices[i + 1]) {
                min = prices[i + 1];
            }
            if (min < prices[i + 1]) {
                difference = Math.max(difference, prices[i + 1] - min);
            }
        }
        return difference;
    }
}