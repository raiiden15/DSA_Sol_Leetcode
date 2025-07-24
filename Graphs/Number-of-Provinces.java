class Solution {
    public void BFS(boolean[] visited, int u, List<List<Integer>> adj, Queue<Integer> q) {
        q.add(u);
        visited[u] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            for (int v : adj.get(curr)) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
    }
    public void DFS(boolean visited[], int u, List<List<Integer>> adj) {
        if (visited[u]) return;
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                DFS(visited, v, adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);            
                }
            }
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // DFS(visited, i, adj);
                BFS(visited, i, adj, q);
                count++;
            }
        }

        return count;
    }
}