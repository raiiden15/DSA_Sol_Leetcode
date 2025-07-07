class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int n = nums.length;
        int count = 1;

        // assuming process 
        for (int i = 1; i < n; i++) {
            if (nums[i] == candidate) {
                count++;
            } else if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else {
                count--;
            }
        }

        // verification, but its not needed, since majority element is always found/ 
        return candidate;
    }
}