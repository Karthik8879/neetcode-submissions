class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for(int s : stones) {
            list.add(s);
        }

        while(list.size() > 1) {
            int max1 = 0;
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i) > list.get(max1)) {
                    max1 = i;
                }
            }
            int p1 = list.remove(max1);

            int max2 = 0;
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i) > list.get(max2)) {
                    max2 = i;
                }
            }
            int p2 = list.remove(max2);

            int val = Math.abs(p1 - p2);
            if(val > 0) {
                list.add(val);
            }
        }
        if(list.size() == 0) {
            return 0;
        } else {
            return list.get(0);
        }
    }
}
