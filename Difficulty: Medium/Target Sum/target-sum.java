class Solution {
    public int totalWays(int[] arr, int target) {
        int sum = 0;
        for(int num : arr) sum += num;

        // edge cases
        if((sum + target) % 2 != 0 || Math.abs(target) > sum) return 0;

        int s = (sum + target) / 2;

        return countSubsets(arr, s);
    }

    private int countSubsets(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[target + 1];
        
        dp[0] = 1; // one way to make sum 0
        
        for(int num : arr){
            for(int j = target; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }
        
        return dp[target];
    }
}