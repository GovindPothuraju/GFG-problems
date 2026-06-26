class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n=arr.length;
        int l=0;
        int sum=0;
        int max=0;
        for(int r=0;r<n;r++){
            sum+=arr[r];
            if(r-l == k){
                sum-=arr[l];
                l++;
            }
            if(r-l+1 == k){
                max=Math.max(max,sum);
            }
        }
        return max;
    }
}