class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        long[] busyUntil = new long[n];
        int[] ans = new int[m];

        long time = 0;

        for (int j = 0; j < m; j++) {
            time = Math.max(time, j);

            int index = -1;

            while (index == -1) {
                for (int i = 0; i < n; i++) {
                    if (busyUntil[i] <= time) {
                        if (index == -1 ||
                            servers[i] < servers[index] ||
                            (servers[i] == servers[index] && i < index)) {
                            index = i;
                        }
                    }
                }

                if (index == -1) {
                    time = Long.MAX_VALUE;

                    for (int i = 0; i < n; i++) {
                        time = Math.min(time, busyUntil[i]);
                    }
                }
            }

            ans[j] = index;
            busyUntil[index] = time + tasks[j];
        }

        return ans;
    }
}
