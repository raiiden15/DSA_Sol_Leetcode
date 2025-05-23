class Solution {
    public int firstMissingPositive(int[] nums) {
        // my approach, but bekar
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                min = Math.min(nums[i], min);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) nums[i] = min;
            System.out.print(nums[i] + \ \);
        }
        System.out.println();
        // cyclic sort 
        for (int i = 0; i < n; i++) {
            while(nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            System.out.print(nums[i] + \ \);
        }

        // checking 
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] != i) {
                return i;
            }
        }

        return n + 1;
    }
}