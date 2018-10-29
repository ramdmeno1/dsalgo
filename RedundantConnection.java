 public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        for (int[] edge: edges){
            int f = edge[0];
            int t = edge[1];

            int parent0 = find(parent, f);
            int parent1 = find(parent, t);
            if (parent0 == parent1) return edge;
            else
                parent[parent0] = parent1;
        }
        return new int[2];
    }

    public int find(int[] parent, int node) {
        int ancestor = parent[node];
        while (ancestor != parent[ancestor]) {
            ancestor = parent[ancestor];
        }
        return ancestor;
    }
}
