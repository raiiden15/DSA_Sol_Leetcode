class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 0;

        while(i < nums.length) {
            if (nums[i] == nums[j]) {
                i++;
            } else {
                nums[++j] = nums[i];
            }
        }

        return j + 1;
    }
}