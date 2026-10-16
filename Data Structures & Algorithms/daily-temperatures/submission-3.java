class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            for(int j = i; j < temperatures.length; j++) {
                if(temperatures[j] > temperatures[i]) {
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }
}
