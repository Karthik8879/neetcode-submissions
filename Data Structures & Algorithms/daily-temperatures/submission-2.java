class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            for(int j = i; j < temperatures.length; j++) {
                if(temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    // public int[] dailyTemperatures3(int[] temperatures) {
    //     Stack<Integer> stack = new Stack<>();
    //     int[] res = new int[temperatures.length];
    //     for(int i = 0; i < temperatures.length; i++) {
    //         stack.push(i);
            
    //     }
    // }

    public int[] dailyTemperatures2(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            for(int j = i+1; j < temperatures.length; j++) {
                if(temperatures[j] > temperatures[i]) {
                    res[i] = j - i; 
                    break;
                }
            }
        }
        return res; // n^2 time and 1 space --> bad --> bruteforce
    }

    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }            }
        }
        return res;
    }
}