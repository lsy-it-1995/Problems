# Brutal Force
* Time Complexity: O(k* n^k)
* Space Complexity: O(n)
## Python 3
```
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        def dp(n):
            if n == 0:
                return 0
            if n < 0:
                return -1
            res = float('INF')
            for coin in coins:
                subproblem = dp(n-coin)
                if subproblem == -1:
                    continue;
                res = min(res, 1 + subproblem)
            return res if res != float('INF') else -1
        return dp(amount)
```

# Recursion with Memorization
* Time Complexity: O(nk)
* Space Complexity: O(n)
## Python 3
```
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = dict()
        def dp(n):
            if n in memo:
                return memo[n]
            if n == 0:
                return 0
            if n < 0:
                return -1
            res = float('INF')
            for coin in coins:
                subproblem = dp(n-coin)
                if subproblem == -1:
                    continue;
                res = min(res, 1 + subproblem)
            memo[n] = res if res != float('INF') else -1
            return memo[n]
        return dp(amount)
```

# Dynamic Programming
* Time Complexity: O(nk)
* Space Complexity: O(n)
## C++
```
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount+1, amount+1);
        dp[0] = 0;
        for(int coin: coins){          
            for(int i = 0; i < dp.size(); i++){
                if(i - coin < 0){
                    continue;
                }
                dp[i] = min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1)? -1: dp[amount];
    }
};
```

## Java
```
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int coin: coins){
            for(int i = coin; i <= amount; i++){
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        return (dp[amount] == amount + 1)? -1: dp[amount];
    }
}
```