class Solution {
    int[][][] mem;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        mem = new int[2][n][n + 1];
        for (int x = 0; x <= 1; x++) {
            for (int y = 0; y < n; y++) {
                for (int z = 0; z <= n; z++) {
                    mem[x][y][z] = -1;
                }
            }
        }
        return dfs(1, 0, 1, piles);
    }

    private int dfs(int alice, int i, int M, int[] piles) {
        if (i == piles.length) {
            return 0;
        }

        if (mem[alice][i][M] != -1) {
            return mem[alice][i][M];
        }

        int stones = 0;
        int res = alice == 1 ? 0 : Integer.MAX_VALUE;
        for (int X = 1; X <= 2 * M; X++) {
            if (i + X - 1 >= piles.length) {
                break;
            }

            stones += piles[i + X - 1];

            if (alice == 1) {
                res = Math.max(res, stones + dfs(0, i + X, Math.max(X, M), piles));
            } else {
                res = Math.min(res, dfs(1, i + X, Math.max(X, M), piles));
            }
        }

        mem[alice][i][M] = res;
        return res;
    }
}