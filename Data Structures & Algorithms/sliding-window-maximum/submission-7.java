class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>(); // storing idx wrt values in decreasing order
        for(int i = 0; i < nums.length; i++) {
            // removing idx outside the window
            while(!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.pollFirst();
            }
            // maintain decreasing order
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i >= k-1) {
                res[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
