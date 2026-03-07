class Solution {
    static int[][] memo;
    static int noOfWays(int m, int n, int x) {
        memo = new int[n + 1][x + 1];
        for(int i=0;i<=n;i++)
            Arrays.fill(memo[i], -1);
        return solve(0, x, m, n);
    }
    static int solve(int st, int target, int m, int n){
        if(target < 0) return 0;
        if(st == n){
            return target == 0 ? 1 : 0;
        }
        if(memo[st][target] != -1)
            return memo[st][target];
        int ways = 0;
        for(int i=1;i<=m;i++){
            ways += solve(st+1, target-i, m, n);
        }
        memo[st][target] = ways;
        return ways;
    }
}