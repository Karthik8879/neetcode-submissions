class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();

        // Node labels are 1 through n.
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[n + 1];
        
            if (dfs(u, v, graph, visited)) {
                return edge;
            }

            // Add the edge only after checking.
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[0];
    }

    private boolean dfs(int node, int target, List<List<Integer>> graph, boolean[] visited) {
        // base case --> if same means edge already exisits this is a cycle case
        if (node == target) {
            return true;
        }

        // if already visited --> false
        if(visited[node]) {
            return false;
        }

        // mark node as visited
        visited[node] = true;

        // loop neighbours and do dfs
        for (int neighbour : graph.get(node)) {
            // do dfs and find if true or not
            if (dfs(neighbour, target, graph, visited)) {
                return true;
            }
        }

        return false;
    }
}