class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int n=arr.length;
        int l=0;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int r=0;r<n;r++){
            sum^=arr[r];
            if(r-l+1>k){
                sum^=arr[l];
                l++;
            }
            if(r-l+1==k){
                max=Math.max(max,sum);
            }
        }
        return max;
    }
}
