class Solution {
    public int numTrees(int n) {
        if(n < 1)
            return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                //dp[j] = 0....(i-j-1)
                //dp[i-j-1] = (i-j-1)....0
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}