class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            // removing from dq whe more than k elements
            while(!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.pollFirst();
            }
            // removing ele to maintain decreasing order
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            // adding into dq
            dq.offerLast(i);
            // populating into res
            if(i >= k-1) {
                res[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
