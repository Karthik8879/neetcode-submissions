class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ele : tasks) {
            hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a,b) -> b - a
        );

        for(int val : hm.values()) {
            maxHeap.offer(val);
        }

        int time = 0;

        while(!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n+1; i++) {
                if(!maxHeap.isEmpty()) {
                    int freq = maxHeap.poll();
                    freq--;
                    temp.add(freq);
                }
            }

            for(int ele : temp) {
                if(ele > 0) maxHeap.offer(ele);
            }
            
            if(maxHeap.size() == 0) {
                time += temp.size();
            } else {
                time += n+1;
            }
        }
        return time;
    }
}
