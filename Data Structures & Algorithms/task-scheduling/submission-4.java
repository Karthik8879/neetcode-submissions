class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char task : tasks) {
            hm.put(task, hm.getOrDefault(task, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(hm.values());

        Collections.sort(list, (a,b) -> b - a);

        int maxFreq = list.get(0);

        int intervals = maxFreq - 1; // we can even call it gaddha
        // we can even call it idleSlots
        int emptySpaces = intervals * n; // in our example we had looked at n = 2

        // here we are traversing from 1 because maxFreq ele is at idx 0 and we do not want to consider that
        for(int i = 1; i < list.size(); i++) {
            emptySpaces -= Math.min(intervals, list.get(i));
        }

        if(emptySpaces == 0) {
            return tasks.length;
        } else {
            return tasks.length + Math.max(0, emptySpaces);
        }
    }
}
