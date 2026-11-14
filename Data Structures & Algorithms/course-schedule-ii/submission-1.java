class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
        }
        int[] state = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if(state[i] == 0) {
                if(!dfs(i, graph, state, order)) {
                    return new int[]{};
                }
            }
        }
        // we are going to be storing the courses in reverse order due to recursion
        // think of it like a stack we have to again pop to get proper order
        Collections.reverse(order);
        int[] ans = new int[order.size()];
        for(int i = 0; i < order.size(); i++) {
            ans[i] = order.get(i);
        }
        return ans;
    }

    boolean dfs(int node, List<List<Integer>> graph, int[] state, List<Integer> order) {
        // base case
        if(state[node] == 1) {
            return false;
        }
        if(state[node] == 2) {
            return true;
        }
        state[node] = 1;
        for(int neighbour : graph.get(node)) {
            if(!dfs(neighbour, graph, state, order)) {
                return false;
            }
        }
        state[node] = 2;
        order.add(node);
        return true;
    }
}
