class Solution {
    // because weights are associated we can't make use of the BFS
    // because the wegiths are non negative --> dijkstras algorithm
    // We use Dijkstra’s algorithm because the weights are nonnegative
    // Always process the node with the smallest known arrival time next.
    // [source, destination, travelTime]
    // k is the start
    public int networkDelayTime(int[][] times, int n, int k) {
        // we have been given an edgeList --> we have to create an adjList
        // build the directed graph for dijkstras
        List<List<int[]>> graph = new ArrayList<>();
        // populating the graph wrt new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // populating the graph
        for(int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            graph.get(from).add(new int[]{to, weight});
        }
        // 2. Track the best known arrival time for each node.
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // we are making because we are going to be having the starting point

        // Each entry is {node, arrivalTime}.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        minHeap.offer(new int[]{k, 0}); // populating the minHeap with the start and distance is 0

        // 4. Find shortest arrival times.
        while(!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int currentTime = current[1];

            // Ignore an older, slower entry for this node.
            if (currentTime > dist[node]) {
                continue;
            }

            for(int[] edge : graph.get(node)) {
                int neighbour = edge[0];
                int weight = edge[1];
                int newTime = currentTime + weight;
                if(newTime < dist[neighbour]) {
                    dist[neighbour] = newTime;
                    minHeap.offer(new int[]{neighbour, newTime});
                }
            }

        }
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            answer = Math.max(answer, dist[i]);
        }
        return answer;

    }
}