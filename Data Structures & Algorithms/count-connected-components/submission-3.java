class Solution {
    public int countComponents(int n, int[][] edges) {
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
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(state[i] == 0) {
                dfs(i, graph, state);
                cnt++;
            }
        }
        return cnt;
    }

    void dfs(int node, List<List<Integer>> graph, int[] state) {
        if(state[node] == 2) {
            return;
        }
        if(state[node] == 1) {
            return;
        }
        state[node] = 1;
        for(int neightbour : graph.get(node)) {
            dfs(neightbour, graph, state);
        }
        state[node] = 2;
        return;
    }
}
