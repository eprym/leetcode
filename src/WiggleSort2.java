public class Solution {
    public void wiggleSort(int[] nums) {
       if(nums.length <= 1) return;
       Arrays.sort(nums);
       int median = nums.length % 2 == 0 ? (nums[(nums.length-1)/2]+nums[(nums.length+1)/2])/2 : nums[nums.length/2];
       int first = 0, mid = 0, last = nums.length-1;
       int n = nums.length;
       while(mid <= last){
           if(nums[mapIdx(mid,n)] > median){
               swap(nums, mapIdx(mid,n), mapIdx(first,n));
               first++;
               mid++;
           }
           else if(nums[mapIdx(mid,n)] < median){
               swap(nums, mapIdx(mid,n), mapIdx(last,n));
               last--;
           }
           else mid++;
       }
    }
    
    private int mapIdx(int idx, int n){
        return (2 * idx + 1) % (n | 1);
    } 
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}
