// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        Collections.sort(arr);
        int l = 0;
        int n = arr.size(); 
        int mini = Integer.MAX_VALUE;

        for (int r = l + m - 1; r < n; r++) {
            mini = Math.min(mini, arr.get(r) - arr.get(l));
            l++;
        }
        return mini;
    }
}