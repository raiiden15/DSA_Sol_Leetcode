class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void helper(int index, int[] nums) {
        if (index == nums.length - 1) {
            List<Integer> prem = new ArrayList<>();
            for (int x : nums) {
                prem.add(x);
            }
            result.add(prem);
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(nums, i, index);
                helper(index + 1, nums);
                swap(nums, i, index); // backtrack. 
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        helper(0, nums);
        return result;
    }
}