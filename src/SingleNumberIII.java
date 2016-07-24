public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int diff = 0;
        for(int num : nums) {
            diff ^= num;
        }
        int last_set_bit = diff & ~(diff - 1);
        for(int num : nums) {
            if((num & last_set_bit) == 0) res[0] ^= num;
            else    res[1] ^= num;
        }
        return res;
    }
}
