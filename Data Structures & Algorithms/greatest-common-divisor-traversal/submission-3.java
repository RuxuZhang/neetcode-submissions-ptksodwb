class UnionFind {
    int n;
    int[] root;
    int[] size;

    public UnionFind(int n) {
        this.n = n;
        this.root = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            this.root[i] = i;
            this.size[i] = 1;
        }
    }

    public int find(int i) {
        if (root[i] == i) return i;
        else return find(root[i]);
    }

    public void union(int i, int j) {
        int ri = find(i);
        int rj = find(j);
        if (ri == rj) return;

        n--;
        if (size[ri] < size[rj]) {
            int tmp = ri;
            ri = rj;
            rj = tmp;
        }

        root[rj] = root[ri];
        size[ri] += size[rj];
    }
}

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> factorIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int f = 2;

            while (f * f <= num) {
                if (num % f == 0) {
                    if (!factorIndex.containsKey(f)) {
                        factorIndex.put(f, i);
                    } else {
                        uf.union(factorIndex.get(f), i);
                    }
                }

                while (num % f == 0) {
                    num /= f;
                }

                f++;
            }

            if (num > 1) {
                if (!factorIndex.containsKey(num)) {
                    factorIndex.put(num, i);
                } else {
                    uf.union(factorIndex.get(num), i);
                }
            }
        }

        return uf.n == 1;
    }
}