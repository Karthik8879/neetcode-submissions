class Solution {
    class Custom{
        int idx;
        int val;
        Custom(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Custom> dq = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            // removing from dq whe more than k elements
            while(!dq.isEmpty() && dq.peekFirst().idx <= i-k) {
                dq.pollFirst();
            }
            // removing ele to maintain decreasing order
            while(!dq.isEmpty() && dq.peekLast().val <= nums[i]) {
                dq.pollLast();
            }
            // adding into dq
            dq.offerLast(new Custom(i, nums[i]));
            // populating into res
            if(i >= k-1) {
                res.add(dq.peekFirst().val);
            }
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
