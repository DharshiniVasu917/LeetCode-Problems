class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        Integer[][][] dp = new Integer[m+1][n+1][maxMove+1];
        return recur(startRow, startColumn, m,n, maxMove, dp)%1_000_000_007;
    }

    private int recur(int i, int j, int m, int n, int mm, Integer[][][] dp){

        if(i<0 || j<0 || i>=m || j>=n){
            if(mm>=0) return 1;
            return 0;
        }
       
        if(mm==0) return 0;

        if(dp[i][j][mm]!=null) return dp[i][j][mm];

        long d = (long)recur(i+1, j, m, n, mm-1, dp);
        long r = (long)recur(i, j+1, m, n, mm-1, dp);
        long u = (long)recur(i-1, j, m, n, mm-1, dp);
        long l = (long)recur(i, j-1, m, n, mm-1, dp);

        return dp[i][j][mm] = (int)((d+r+u+l)%1_000_000_007);
    }

}
