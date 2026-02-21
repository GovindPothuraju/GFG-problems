class Solution {
    public int hIndex(int[] citations) {
        // code here
        int n=citations.length;
        int l=0;
        int r=0;
        for(int i=0;i<n;i++){
            r=Math.max(r,citations[i]);
        }
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(citations,mid)){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return r;
    }
    private boolean isPossible(int[] arr,int k){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] >= k){
                count++;
            }
        }
        return count>=k;
    }
}