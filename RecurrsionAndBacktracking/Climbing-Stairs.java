class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 1 || n == 0) return 1;
        // see if we have processes that particular number before in left or right substree 
        if (map.get(n) != null) return map.get(n);
        int totalways = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, totalways);
        return totalways;
    }
}