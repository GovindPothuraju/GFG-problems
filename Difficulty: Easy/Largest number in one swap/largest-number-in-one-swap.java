class Solution {
    public String largestSwap(String s) {
        // code here
        char[] arr = s.toCharArray();
        char maxDigit='0';
        int maxIndex=-1;
        int l=-1;
        int r=-1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>maxDigit){
                maxDigit=arr[i];
                maxIndex=i;
            }else if(arr[i]<maxDigit){
                l=i;
                r=maxIndex;
            }
        }
        if(l==-1)return s;
        char temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
        return String.valueOf(arr);
    }
    
}