class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // making the adjList
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // populating the graph wrt the values inside of the times
        for(int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            // populating the adjList wrt the values from times
            graph.get(from).add(new int[]{to, weight});
        }

        // storing the result
        int[] dist = new int[n+1];
        // populating it wrt Integer.MAX_VALUE
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Make minHeap for dijkstras algorithm
        // because here we are going to be doing the minHeap wrt the distance
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );

        // populating the dist --> wrt the start for understanding
        dist[k] = 0;
        // also once we have added into dist --> according to rule we are also going to be insrting into the minHeap
        minHeap.offer(new int[]{k, 0});

        // now we can start with our problem
        while(!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int distance = current[1];

            // if we are going to be having the distance > dist[node] --> we can skip it because we are not going to be getting a lower value for sure
            if(distance > dist[node]) {
                continue;
            }

            // we are traversing through the int[] inside of the List<int[]>
            for(int[] edge : graph.get(node)) {
                int neighbour = edge[0];
                int weight = edge[1];
                int newWeight = weight + distance; // we have to be considering the distance instead of looking it up wrt newWeight = weight + dist[node] --> because it can happen that we are going to be having more distance as compared to dist[node] ? 5,10 and 5,8 case where we were looking at 5,10 when we had store 8 in dist array
                if(newWeight < dist[neighbour]) {
                    dist[neighbour] = newWeight; // update the dist
                    // now as per rule when dist is updated we have to offer into minHeap
                    minHeap.offer(new int[]{neighbour, newWeight});
                }
            }
        }
        // now we have populated the graph completely
        int maxTime = 0;
        // if we have not visited a particular node then we have to return 0 because it is not connected graph
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                // we never reached it --> all nodes can not receive the signal for sure
                return -1;
            }
            // here we are doing this because in graph we can traverse multiple paths at the same time so the time of the maxDist[i] would be the maxTime and others will take place at the same time
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}
