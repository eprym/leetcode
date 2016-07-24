public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, mask = 0;
        for(int n : nums) {
            twos ^= (ones & n);
            ones ^= n;
            mask = ~(ones & twos);
            ones &= mask;
            twos &= mask;
        }
        return ones;
    }
}

/*ref
https://www.careercup.com/question?id=7902674
https://discuss.leetcode.com/topic/11877/detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers
*/
