class Solution {
    public boolean validTree(int n, int[][] edges) {
        // make a adjList from this edgeList
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        // building boolean visited
        boolean[] visited = new boolean[n];
        // we do not have to loop we have to be starting from 0 and we have to be able to reach everying
        if(!dfs(0, -1, graph, visited)) {
            return false;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited) {
        // if already visited and not parent
        if(visited[node]) {
            return false; // we do not have to wrte anything wrt parent because we are reaching this in other case - in normal case we are going to be doing neighbour, node -> so -> node, parent
        }
        // marking as visited
        visited[node] = true;
        // doing dfs wrt neighbours
        for(int neighbour : graph.get(node)) {
            if(neighbour == parent) {
                continue;
            }
            // call dfs
            if(!dfs(neighbour, node, graph, visited)) {
                return false;
            }
        }
        return true;
    }
}
