public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0)  return 0;
        int[][] mCost = new int[costs.length][3];
        mCost[0][0] = costs[0][0];
        mCost[0][1] = costs[0][1];
        mCost[0][2] = costs[0][2];
        
        for(int i = 1; i < mCost.length; i++) {
            mCost[i][0] = Math.min(mCost[i-1][1], mCost[i-1][2]) + costs[i][0];
            mCost[i][1] = Math.min(mCost[i-1][0], mCost[i-1][2]) + costs[i][1];
            mCost[i][2] = Math.min(mCost[i-1][1], mCost[i-1][0]) + costs[i][2];
        }
        return Math.min(mCost[mCost.length-1][0], Math.min(mCost[mCost.length-1][1], mCost[mCost.length-1][2]));
    }
}
