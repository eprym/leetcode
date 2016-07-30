public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0)  return 0;
        int[] mCost = new int[costs[0].length];
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        
        for(int i = 0; i < costs.length; i++) {
            int min1_old = i == 0 ? 0 : min1;
            int min2_old = i == 0 ? 0 : min2;
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            for(int j = 0; j < costs[0].length; j++) {
                mCost[j] = mCost[j] == min1_old ? min2_old + costs[i][j] : min1_old + costs[i][j];
                if(min1 < mCost[j]) {
                    min2 = Math.min(mCost[j], min2);
                }
                else {
                    min2 = min1;
                    min1 = mCost[j];
                }
            }
        }
        return min1;
    }
}
