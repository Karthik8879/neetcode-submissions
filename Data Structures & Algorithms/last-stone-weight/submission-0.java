class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < stones.length; i++) {
            list.add(stones[i]);
        }

        while(list.size() > 1) {
            Collections.sort(list, Collections.reverseOrder());
            int ele1 = list.get(0);
            int ele2 = list.get(1);

            list.remove(0);
            list.remove(0);

            int val = ele1 - ele2;

            if(val > 0) {
                list.add(val);
            }
        }

        if(list.size() == 1) {
            return list.get(0);
        }
        
        return 0;
    }
}
