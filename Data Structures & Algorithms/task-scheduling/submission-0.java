class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char task : tasks) {
            hm.put(task, hm.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a,b) -> b - a
        );

        for(int ele : hm.values()) {
            maxHeap.offer(ele);
        }

        int time = 0;

        while(!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // we have to perform n tasks -> because if we have to input A then n = 2 so we have to input A and then wait for 2 others before we are going to input A again so n+1 because of that
            for(int i = 1; i <= n+1; i++) {
                if(!maxHeap.isEmpty()) {
                    int freq = maxHeap.poll();
                    freq--;
                    temp.add(freq);
                }
            }
            for(int ele : temp) {
                if(ele > 0) {
                    maxHeap.offer(ele);
                }
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
