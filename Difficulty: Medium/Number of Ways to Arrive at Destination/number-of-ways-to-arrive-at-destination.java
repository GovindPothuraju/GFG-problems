import java.util.*;

class Solution {
    public int countPaths(int V, int[][] edges) {
        
        // Step 1: Build graph
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] e : edges){
            int u = e[0], v = e[1], wt = e[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        
        // Step 2: Dijkstra setup
        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        int[] ways = new int[V];
        int mod = (int)1e9 + 7;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );
        
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0}); // {distance, node}
        
        // Step 3: Dijkstra
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int)curr[1];
            
            if(d > dist[node]) continue;
            
            for(int[] nei : adj.get(node)){
                int next = nei[0];
                long newDist = d + nei[1];
                
                // Case 1: Better path found
                if(newDist < dist[next]){
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    pq.offer(new long[]{newDist, next});
                }
                
                // Case 2: Same shortest path
                else if(newDist == dist[next]){
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }
        
        return ways[V - 1];
    }
}