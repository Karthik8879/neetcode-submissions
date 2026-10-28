class Solution {
    public boolean validTree(int n, int[][] edges) {
        // making adjList wrt edgeList
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // populating the graph wrt the edgeList
        for(int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        // having visited check
        boolean[] visited = new boolean[n];
        // doing dfs wrt the 0th node because we have to have all connected if it is a tree
        if(!dfs(0, -1, graph, visited)) {
            return false;
        }
        // loop and find if all are visited --> if not that means disconnected so not a tree for sure
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited) {
        // if already visited mark as false
        if(visited[node]) {
            return false;
        }
        // mark visited
        visited[node] = true;
        // loop and do dfs
        for(int neighbour : graph.get(node)) {
            // if node == parent --> continue
            if(neighbour == parent) {
                continue;
            }
            if(!dfs(neighbour, node, graph, visited)) {
                return false;
            }
        }
        return true;
    }
}
