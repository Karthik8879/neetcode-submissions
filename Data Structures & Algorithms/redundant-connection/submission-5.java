class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = edges.length+1;
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int e1 = edge[0];
            int e2 = edge[1];
            int[] state = new int[n];
            if(dfs(e1, e2, graph, state)) {
                return edge;
            }
            graph.get(e1).add(e2);
            graph.get(e2).add(e1);
        }
        return new int[]{};
    }

    boolean dfs(int node, int target, List<List<Integer>> graph, int[] state) {
        if(node == target) {
            return true;
        }
        if(state[node] == 2) {
            return true;
        }
        if(state[node] == 1) {
            return false;
        }
        state[node] = 1;
        for(int neighbour : graph.get(node)) {
            if(state[neighbour] == 0 && dfs(neighbour, target, graph, state)){
                return true;
            }
        }
        state[node] = 2;
        return false;
    }
}
