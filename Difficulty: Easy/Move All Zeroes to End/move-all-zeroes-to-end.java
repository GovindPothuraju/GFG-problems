class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int i=0,j=0;
        while(j<arr.length){
            if(arr[j] != 0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }else{
                j++;
            }
        }
    }
}