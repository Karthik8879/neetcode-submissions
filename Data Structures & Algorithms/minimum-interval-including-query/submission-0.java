class Solution {
    class Custom {
        int len;
        int end;

        Custom(int len, int end) {
            this.len = len;
            this.end = end;
        }
    }

    class Query {
        int value;
        int index;

        Query(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int n = queries.length;
        int[] res = new int[n];

        // Store each query with its original index
        Query[] sortedQueries = new Query[n];

        for(int i = 0; i < n; i++) {
            sortedQueries[i] = new Query(queries[i], i);
        }

        // Sort sortedQueries by value
        Arrays.sort(sortedQueries, (a,b) -> a.value - b.value);

        // MinHeap based on interval length
        PriorityQueue<Custom> minHeap = new PriorityQueue<>(
            (a,b) -> a.len - b.len
        );

        int i = 0;

        for(Query query : sortedQueries) {
            int q = query.value;

            // Add intervals whose start <= query
            while(i < intervals.length && intervals[i][0] <= q) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                int len = end - start + 1;
                minHeap.offer(new Custom(len, end));
                i++;
            }

            // Removing the intervals which have expired ie gone beyond the query point
            // here we are looking at q value which has gone past the end point of the interval
            while(!minHeap.isEmpty() && minHeap.peek().end < q) {
                minHeap.poll();
            }

            // Store the answer again into the original query point value
            if(minHeap.isEmpty()) {
                res[query.index] = -1;
            } else {
                res[query.index] = minHeap.peek().len;
            }
        }
        return res;
    }
}
