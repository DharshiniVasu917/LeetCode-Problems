class Solution {
    int[][] rects;

    public Solution(int[][] rects) {
        this.rects = rects;
    }

    public int[] pick() {
        int [] res = new int[2];
        Random random = new Random();

        int maxWidth  = 0;
        for (int i = 0 ; i < rects.length; i++) {
            maxWidth = maxWidth + Math.abs(rects[i][2] - rects[i][0]);
        }

        int x = random.nextInt(maxWidth);

        int rectWidth = 0;
        int rectNum = 0;
        for (int i = 0 ; i < rects.length; i++) {
            rectWidth = Math.abs(rects[i][2] - rects[i][0]);
            x = x - rectWidth;
            if (x <= 0) {
                res[0] = rects[i][2] - Math.abs(x);
                rectNum = i;
                break;
            }
        }

        int y = 0;
        int rectHeight = Math.abs(rects[rectNum][3] - rects[rectNum][1]);
        if ( rectHeight > 0 ) y = random.nextInt(Math.abs(rects[rectNum][3] - rects[rectNum][1]));

        res[1] = rects[rectNum][1] + y;

        return res;
    }
}
