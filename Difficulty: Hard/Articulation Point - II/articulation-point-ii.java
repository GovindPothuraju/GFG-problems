import java.util.*;

class Solution {
    static int time;

    static void dfs(int u, int parent, ArrayList<ArrayList<Integer>> adj,
                    boolean[] visited, int[] disc, int[] low,
                    boolean[] isAP) {
        
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == parent) continue;

            if (!visited[v]) {
                children++;
                dfs(v, u, adj, visited, disc, low, isAP);

                low[u] = Math.min(low[u], low[v]);

                // Case 1: root node
                if (parent == -1 && children > 1)
                    isAP[u] = true;

                // Case 2: non-root
                if (parent != -1 && low[v] >= disc[u])
                    isAP[u] = true;

            } else {
                // Back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Build graph
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];

        time = 0;

        // Handle disconnected graph
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, visited, disc, low, isAP);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isAP[i]) result.add(i);
        }

        if (result.size() == 0) {
            result.add(-1);
        }

        return result;
    }
}