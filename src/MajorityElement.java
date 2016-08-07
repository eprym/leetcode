public class Solution {
    public int majorityElement(int[] nums) {
        int major = 0, counts = 0;
        for(int i = 0; i < nums.length; i++) {
            if(counts == 0) {
                major = nums[i];
                counts++;
            }
            else {
                counts += (major == nums[i]) ? 1 : -1;
            }
        }
        return major;
    }
}
