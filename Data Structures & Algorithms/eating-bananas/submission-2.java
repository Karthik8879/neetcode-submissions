class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;
        for(int pile : piles) {
            high = Math.max(high, pile);
        }

        int low = 1;
        int ans = high;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(helper(piles, mid, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean helper(int[] piles, int i, int h) {
        int totalHours = 0;
        for(int pile : piles) {
            totalHours += (int) Math.ceil((double) pile/ i);
        }
        if(totalHours <= h) {
            return true;
        }
        return false;
    }
}
