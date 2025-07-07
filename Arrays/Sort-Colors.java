class Solution {
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0; 
        int j = 0; 
        int k = n - 1;

        while (j <= k) {
            if (nums[j] == 2) {
                swap(j, k--, nums);
            } else if (nums[j] == 0) {
                swap(j++, i++, nums);
            } else {
                j++;
            }
        }
    }
}