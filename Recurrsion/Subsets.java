class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public void sub(ArrayList<Integer> list, int[] nums, int idx) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        // do no pick element
        sub(list, nums, idx + 1);

        // pick element
        list.add(nums[idx]);
        sub(list, nums, idx + 1);
        list.remove(list.size() - 1);
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        sub(new ArrayList<Integer>(), nums, 0);
        return result;
    }
}