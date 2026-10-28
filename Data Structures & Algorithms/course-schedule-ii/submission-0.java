class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        // populating adjList wrt new ArrayList<>()
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // populating the graph wrt prerequisites
        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
        }
        
        // 0 = unvisited
        // 1 = currently visiting
        // 2 = completely processed
        int[] state = new int[numCourses];
        List<Integer> order = new ArrayList<>(); // where we are going to be storing our answer

        // perform dfs
        for(int i = 0; i < numCourses; i++) {
            // not visited yet
            if(state[i] == 0) {
                if(!dfs(i, graph, state, order)) {
                    return new int[0];
                }
            }
        }

        Collections.reverse(order);
        int[] res = new int[order.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = order.get(i);
        }
        return res;
    }

    boolean dfs(int node, List<List<Integer>> graph, int[] state, List<Integer> order) {
        // base case --> already visited
        if(state[node] == 1) {
            return false;
        }
        // if we have reachhed answer
        if(state[node] == 2) {
            return true;
        }
        // mark as visited
        state[node] = 1;
        // do dfs
        for(int neighbour : graph.get(node)) {
            // do dfs
            if(!dfs(neighbour, graph, state, order)) {
                return false;
            }
        }
        state[node] = 2;
        order.add(node);
        return true;
    }
}