class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i = 0; 
        int j =  n - 1;
        int idx = n - 1;
        while (i <= j) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[idx--] = nums[i] * nums[i];
                i++;
            } else if (nums[i] * nums[i] <= nums[j] * nums[j]) {
                result[idx--] = nums[j] * nums[j];
                j--;
            }
        }

        return result;
    }
}