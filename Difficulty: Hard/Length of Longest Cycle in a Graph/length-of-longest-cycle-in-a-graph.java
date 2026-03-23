class Solution {
    public int longestCycle(int V, int[][] edges) {
        
        int[] nextNode = new int[V];
        Arrays.fill(nextNode, -1);

        // build graph
        for (int[] e : edges) {
            nextNode[e[0]] = e[1];
        }

        int[] visited = new int[V];
        int ans = -1;

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                int node = i;
                int time = 0;

                HashMap<Integer, Integer> map = new HashMap<>();

                while (node != -1 && visited[node] == 0) {
                    visited[node] = 1;
                    map.put(node, time++);

                    node = nextNode[node]; 
                    }

                if (node != -1 && map.containsKey(node)) {
                    int cycleLength = time - map.get(node);
                    ans = Math.max(ans, cycleLength);
                }
            }
        }

        return ans;
    }
}