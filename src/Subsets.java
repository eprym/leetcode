public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subresult = new ArrayList<>();
        Arrays.sort(nums);
        bp(0, nums, result, subresult);
        return result;
    }
    
    private void bp(int i, int[] nums, List<List<Integer>> result, List<Integer> subresult){
        if(i == nums.length){
            List<Integer> copy = new ArrayList<>(subresult);
            result.add(copy);
            return;
        }
        subresult.add(nums[i]);
        bp(i+1, nums, result, subresult);
        subresult.remove(subresult.size()-1);
        bp(i+1, nums, result, subresult);
    }
}
