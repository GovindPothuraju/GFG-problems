class Solution {
    public int countIncreasing(int[] arr) {
        // code here
        int res=0;
        int l=0;
        for(int r=1;r<arr.length;r++){
            if(arr[r]>arr[r-1]){
                continue;
            }else{
                int len=r-l;
                res += (len * (len - 1)) / 2;
                l = r;
            }
        }
        int len = arr.length - l;
        res += (len * (len - 1)) / 2;
        return res;
    }
}
