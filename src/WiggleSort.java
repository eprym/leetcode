public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums.length == 0)    return;
        for(int i=0; i<nums.length; i++){
            if(i%2 == 1){
                if(nums[i] < nums[i-1]) swap(nums, i-1, i);
            }
            else if(i != 0 && nums[i] > nums[i-1])  swap(nums, i-1, i);
        }
        
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
