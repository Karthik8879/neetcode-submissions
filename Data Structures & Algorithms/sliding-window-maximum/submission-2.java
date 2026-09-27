class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            // remove idx outside the window
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            // maintaining decreasing order
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);
            if(i >= k - 1) {
                res[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        for(int i = 0; i < nums.length-k+1; i++) {
            int max = 0;
            for(int j = i; j < i+k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}
