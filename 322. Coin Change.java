import java.util.*;
class Solution {
    public int coinChange(int[] den, int req) {
        int def=req+1;
        int [] dp=new int [def];
        Arrays.fill(dp,def);
        dp[0]=0;
        for(int cur:den){
            for(int index=cur;index<=req;index++){
             dp[index]=Math.min (dp[index],1+dp[index-cur]);
            }
        }
        return dp[req] == def ? -1 : dp[req];
    }

}
