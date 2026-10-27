class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            graph.get(prerequisite).add(course); // made the adjList
        }

        // 0 = unvisited
        // 1 = currently visiting
        // 2 = completely processed
        int[] state = new int[numCourses];

        // starting DFS
        for(int i = 0; i < numCourses; i++) {
            // not visited till now
            if(state[i] == 0) {
                if(!dfs(i, graph, state)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int node, List<List<Integer>> graph, int[] state) {
        // base case --> cycle detected
        if(state[node] == 1) {
            return false;
        }
        // base case --> already completely processed
        if(state[node] == 2) {
            return true;
        }
        // mark current node as visited
        state[node] = 1;
        // do dfs
        for(int neighbour : graph.get(node)) {
            if(!dfs(neighbour, graph, state)) {
                return false;
            }
        }
        // after exploring all paths we are going to mark visited
        state[node] = 2;
        return true;
    }
}
