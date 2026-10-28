class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        // populating the graph
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // populate graph wrt edges
        for(int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        // keeping track of visited --> boolean
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            // if not visited
            if(!visited[i]) {
                // increment cnt and do dfs
                cnt++;
                dfs(i, graph, visited);
            }
        }
        return cnt;
    }

    void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        // base case --> already visited
        if(visited[node]) {
            return;
        }
        // mark as visited
        visited[node] = true;
        // do dfs wrt traversal of neighbours
        for(int neighbour : graph.get(node)) {
            // just do dfs call\
            dfs(neighbour, graph, visited);
        }
    }
}
