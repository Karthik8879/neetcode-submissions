class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int e1 = edge[0];
            int e2 = edge[1];
            graph.get(e1).add(e2);
            graph.get(e2).add(e1);
        }
        int[] state = new int[n];
        // we are not doing for loop because we have to check for DAG and connected components together
        if(!dfs(0, graph, state, -1)) {
            return false;
        }
        // if all are not visited it can be a DAG but will not be a tree 
        // because for being tree all have to be connected from root to leaf
        for(int i = 0; i < n; i++) {
            if(state[i] == 0) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int node, List<List<Integer>> graph, int[] state, int parent) {
        // base case
        if(state[node] == 2) {
            return true;
        }
        // base case
        if(state[node] == 1) {
            return false;
        }
        state[node] = 1;
        for(int neighbour : graph.get(node)) {
            if(neighbour == parent) {
                continue;
            }
            if(!dfs(neighbour, graph, state, node)) {
                return false;
            }
        }
        state[node] = 2;
        return true;
    }
}
