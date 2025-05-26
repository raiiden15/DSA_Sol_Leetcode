class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // ignore the duplicate elements
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            twoSum(nums, target, i + 1, nums.length - 1, list);
        }
        return list;
    }

    public void twoSum(int[] nums, int target, int start, int end, List<List<Integer>> list) {
        // here sorted nums is passed, hence we can directly implement 2 pointers
        while (start < end) {
            // first we need to remove duplicate condition
            if (nums[start] + nums[end] == target) {
                while(start < end && nums[start] == nums[start + 1] && start > 0) start++;
                while(start < end && nums[end] == nums[end - 1]) end--;
                list.add(Arrays.asList(-target, nums[start], nums[end]));
                start++;
                end--;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
    }
}