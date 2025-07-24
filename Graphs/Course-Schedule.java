class Solution {
    // BFS Cycle Detection
    public boolean detectBFS(List<List<Integer>> adj, int[] indegree) {
        // Kahn's Algorithm, if our count == number of nodes in graph, then no cycle i.e here we need to return false if cycle is present. 
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                    count++;
                }
            }
        }
        return count == indegree.length;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[]: prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        int igd[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int v : adj.get(i)) {
                igd[v]++;
            }
        }
        return detectBFS(adj, igd);
    }
}

// DFS Cycle Detection
// class Solution {
//     // public boolean dfs(List<List<Integer>> adj, int u, int[] visited) {
//     //     if (visited[u] == 1) return true;
//     //     if (visited[u] == 2) return false;
//     //     visited[u] = 1;

//     //     for (int v : adj.get(u)) {
//     //         if (dfs(adj, v, visited)) {
//     //             return true;
//     //         }
//     //     }
//     //     visited[u] = 2;
//     //     return false;
//     // }

//     public boolean check(List<List<Integer>> adj, int u, boolean[] visited, boolean[] inR) {
//         visited[u] = true;
//         inR[u] = true;

//         for (int v : adj.get(u)) {
//             if (!visited[v] && check(adj, v, visited, inR)) return true;
//             else if (inR[v]) return true;
//         }

//         inR[u] = false;
//         return false;
//     }
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         // graph banalia 
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < numCourses; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int preq[]: prerequisites) {
//             int u = preq[0];
//             int v = preq[1];
//             adj.get(u).add(v);
//         }

//         // int visited[] = new int[numCourse];
//         boolean[] visited = new boolean[numCourses];
//         boolean[] inR = new boolean[numCourses];

//         for (int i = 0; i < numCourses; i++) {
//             if (!visited[i] && check(adj, i, visited, inR)) return false;
//         }
    
//         return true;
//     }
// }