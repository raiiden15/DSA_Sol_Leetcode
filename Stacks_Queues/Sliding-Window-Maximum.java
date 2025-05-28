class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            while(!dq.isEmpty() && dq.peekLast() < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            ans[i - k] = dq.peekFirst();
            int outElem = nums[i - k];
            if (outElem == dq.peekFirst()) {
                dq.removeFirst();
            }
            int incomingElem = nums[i];
            while(!dq.isEmpty() && dq.peekLast() < incomingElem) {
                dq.removeLast();
            }
            dq.addLast(incomingElem);
        }

        ans[ans.length - 1] = dq.peekFirst();
        return ans;
    }
}