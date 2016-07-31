public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int rob = nums[0], noRob = 0;
        for(int i = 1; i < nums.length; i++) {
            int tmp = noRob;
            noRob = Math.max(noRob, rob);
            rob = tmp + nums[i];
        }
        return Math.max(rob, noRob);
    }
}
