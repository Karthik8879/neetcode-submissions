class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if(hm.containsKey(diff)) {
                return new int[]{hm.get(diff)+1, i+1};
            }
            hm.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }
}
