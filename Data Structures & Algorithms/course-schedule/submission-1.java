class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // we have to make a adjList\
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // populating the graph wrt the prerequisits and courses given to me
        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
        }

        int[] state = new int[numCourses];
        // can be 0, 1 or 2
        // 0 means not visited
        // 1 means visited
        // 2 means processing is over --> answer

        // starting dfs
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
        // base case --> already completed processed
        if(state[node] == 2) {
            return true;
        }
        // mark state of node as visited
        state[node] = 1;
        // do dfs
        for(int neighbour : graph.get(node)) {
            if(!dfs(neighbour, graph, state)) {
                return false;
            }
        }
        state[node] = 2;
        return true;
    }
}
