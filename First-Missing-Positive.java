class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // cyclic sorting for only numbers lying between 1 and n. 
        for (int i = 0; i < n; i++) {
            // check for 1 to n AND 
            /* 
            1, 2, 3, 4
            nums[1] = 2;
            nums[nums[1] - 1] = nums[2 - 1] = nums[1] = 2; 
            why they should not be equal ? 
            since they are already in correct position, as soon as they get into correct position, 
            we need to break out of the loop. 
             */
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1 ];
                //nums[i] = nums[nums[i] - 1]
                //nums[nums[i] - 1] = temp;
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (i != nums[i - 1] ) {
                return i; 
            }
        }
        return n + 1; 
    }
}