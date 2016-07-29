public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null)    return;
        int i = 0, j = 0;
        while(i < nums.length && j < nums.length) {
            while(i < nums.length && nums[i] != 0)    i++;
            while(j < nums.length && nums[j] == 0)    j++;
            if(i < j && i < nums.length && j < nums.length){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            j++;
        }
    }
}
