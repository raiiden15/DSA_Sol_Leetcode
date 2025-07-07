class Solution {
    public int findDuplicate(int[] nums) {
        // cyclic sort 
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            while(nums[cur - 1] != cur) {
                int temp = nums[cur - 1];
                nums[cur - 1] = cur;
                cur = nums[i] = temp;    
            }
        }

        // check duplicates
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return -1;
    }
}

/* 
Can also be done by simply adding all the numbers and taking the actual sum, and then subtracting to get original missing value. 
 */