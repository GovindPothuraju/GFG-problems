class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int res=Integer.MIN_VALUE;
        int curr=0;
        for(int i=0;i<arr.length;i++){
            curr+=arr[i];
            
            res=Math.max(res,curr);
            if(curr<0){
                curr=0;
            }
        }
        return res;
    }
}
