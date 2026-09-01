import java.util.*;

class Solution {

    static class State {
        int r;
        int c;
        int energy;
        int mask;

        State(int r, int c, int energy, int mask) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length;

        int startR = 0;
        int startC = 0;

        List<int[]> litter = new ArrayList<>();

        // Find starting position and litter
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    startR = i;
                    startC = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    litter.add(new int[]{i, j});
                }
            }
        }

        int litterCount = litter.size();

        if (litterCount == 0) {
            return 0;
        }

        int allMask = (1 << litterCount) - 1;

        /*
         * litterMask[r][c] tells which litter
         * is present at this cell.
         */
        int[][] litterMask = new int[m][n];

        for (int i = 0; i < litterCount; i++) {
            int r = litter.get(i)[0];
            int c = litter.get(i)[1];

            litterMask[r][c] = 1 << i;
        }

        /*
         * visited[r][c][energy][mask]
         */
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        Queue<State> queue = new LinkedList<>();

        queue.offer(new State(startR, startC, energy, 0));

        visited[startR][startC][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {

                State current = queue.poll();

                // All litter collected
                if (current.mask == allMask) {
                    return moves;
                }

                for (int d = 0; d < 4; d++) {

                    int nr = current.r + dr[d];
                    int nc = current.c + dc[d];

                    // Outside grid
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    // Wall
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    // Need energy to move
                    if (current.energy == 0) {
                        continue;
                    }

                    int newEnergy = current.energy - 1;

                    /*
                     * Recharge cell
                     */
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    /*
                     * Collect litter
                     */
                    int newMask = current.mask | litterMask[nr][nc];

                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        queue.offer(
                            new State(
                                nr,
                                nc,
                                newEnergy,
                                newMask
                            )
                        );
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}
