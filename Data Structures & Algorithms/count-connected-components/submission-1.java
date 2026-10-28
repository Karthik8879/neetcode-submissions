class Solution {
    public int countComponents(int n, int[][] edges) {
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

        // keeping track wrt visited --> boolean array
        boolean[] visited = new boolean[n];

        // looping and doing dfs and incrementing cnt
        // also keeping another variable to keep track of cnt
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            // if not visited we are going to be traversing
            if(!visited[i]) {
                cnt++;
                dfs(i, graph, visited); // over here we do not care regarding parent or not because we are not checking for the tree condition in this problem
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
        // do dfs
        for(int neighbour : graph.get(node)) {
            // do dfs call
            dfs(neighbour, graph, visited);
        }
    }
}
