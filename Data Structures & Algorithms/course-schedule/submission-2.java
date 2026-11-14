class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            graph.get(prerequisite).add(course);
        }

        int[] state = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(state[i] == 0) {
                if(!dfs(graph, i, state)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(List<List<Integer>> graph, int node, int[] state) {
        // base case
        if(state[node] == 1) {
            return false; // already visited and cycle detected
        }
        if(state[node] == 2) {
            return true; // this is just return true to the parent in recursion because already processed
        }
        // mark as visited
        state[node] = 1;
        // do dfs
        for(int neighbour : graph.get(node)) {
            if(!dfs(graph, neighbour, state)) {
                return false;
            }
        }
        // after processing all nodes mark that node as visited
        state[node] = 2;
        return true;
    }
}
