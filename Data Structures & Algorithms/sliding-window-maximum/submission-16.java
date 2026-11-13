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
            // size > k
            if(!dq.isEmpty() && dq.peekFirst().idx <= i-k) {
                dq.pollFirst();
            }
            // maintain decreasing order
            while(!dq.isEmpty() && nums[i] > dq.peekLast().val) {
                dq.pollLast();
            }
            // populating the dq
            dq.offerLast(new Custom(i, nums[i]));

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
