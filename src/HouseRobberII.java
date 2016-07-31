public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        if(nums.length == 1)    return nums[0];
        int rob1 = nums[0], rob2 = 0;
        int noRob1 = 0, noRob2 = 0;
        int tmp;
        for(int i = 1; i < nums.length; i++) {
            tmp = noRob1;
            noRob1 = Math.max(rob1, noRob1);
            rob1 = tmp + nums[i];
            tmp = noRob2;
            noRob2 = Math.max(rob2, noRob2);
            rob2 = tmp + nums[i];
        }
        return Math.max(noRob1, rob2);
    }
}
