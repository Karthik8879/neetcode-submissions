class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        for(int i = 0; i < hand.length; i++) {
            hm.put(hand[i], hm.getOrDefault(hand[i], 0) + 1);
        }
        while(!hm.isEmpty()) {
            int card = hm.firstKey();
            for(int i = 0; i < groupSize; i++) {
                int nextCard = card + i;
                if(!hm.containsKey(nextCard)) {
                    return false;
                }
                hm.put(nextCard, hm.get(nextCard)-1);
                if(hm.get(nextCard) == 0) {
                    hm.remove(nextCard);
                }
            }
        }
        return true;
    }
}
