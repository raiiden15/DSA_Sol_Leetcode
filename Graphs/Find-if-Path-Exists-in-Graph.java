class Solution {
    public void dfs(int source, boolean[] b, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> list1) {
        list1.add(source);
        b[source] = true;
        for (int i: list.get(source)) {
            if (b[i] != true) {
                dfs(i, b, list, list1);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        boolean visited[] = new boolean[n];
        ArrayList<Integer> list1 = new ArrayList<>();
        dfs(source, visited, list, list1);
        for (int i : list1) {
            if (i == destination) return true;
        }
        return false;
    }
}