class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (i != headID) {
                graph.get(manager[i]).add(i);
            }
        }

        int result = dfs(graph, headID, informTime);

        return result;
    }

    private int dfs(List<List<Integer>> graph, int node, int[] informTime) {
        if (graph.get(node).isEmpty()) return 0;

        int maxTime = 0;

        for (int subordinate : graph.get(node)) {
            int time = dfs(graph, subordinate, informTime);

            maxTime = Math.max(maxTime, time);
        }

        return informTime[node] + maxTime;
    }
}