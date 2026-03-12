//Approach------>Binary Search
//Time Complexity (TC)----->O(E log S)
//Space Complexity (SC)------------>O(N + E)


class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        int left = 0, right = 200000;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canBuild(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canBuild(int n, int[][] edges, int k, int target) {

        DSU dsu = new DSU(n);
        int used = 0;
        int upgrades = 0;

        // mandatory edges
        for (int[] e : edges) {
            if (e[3] == 1) {
                if (e[2] < target) return false;
                if (!dsu.union(e[0], e[1])) return false;
                used++;
            }
        }

        List<int[]> noUpgrade = new ArrayList<>();
        List<int[]> needUpgrade = new ArrayList<>();

        for (int[] e : edges) {
            if (e[3] == 0) {
                if (e[2] >= target) noUpgrade.add(e);
                else if (2 * e[2] >= target) needUpgrade.add(e);
            }
        }

        // use edges without upgrade first
        for (int[] e : noUpgrade) {
            if (dsu.union(e[0], e[1])) used++;
        }

        // then edges requiring upgrade
        for (int[] e : needUpgrade) {
            if (used == n - 1) break;

            if (dsu.union(e[0], e[1])) {
                upgrades++;
                used++;
                if (upgrades > k) return false;
            }
        }

        return used == n - 1;
    }
}
