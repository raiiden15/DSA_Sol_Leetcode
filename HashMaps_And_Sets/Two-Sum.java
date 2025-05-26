class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int req = target - nums[i];
            if (map.containsKey(req)) {
                return new int[] {i, map.get(req)};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {0, 0};
    }
}

/* 
Brute Force Apprach:  O(n ^ 2)

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int req = target - nums[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == req) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
*/