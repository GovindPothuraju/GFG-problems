class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int n=arr.length;
        
        int[] pse=new int[n];
        int[] nse=new int[n];
        
        Stack<Integer> st1=new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!st1.isEmpty() && arr[st1.peek()] > arr[i]){
                st1.pop();
            }
            pse[i]=st1.isEmpty()?-1:st1.peek();
            st1.push(i);
        }
        
        Stack<Integer> st2=new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            while(!st2.isEmpty() && arr[st2.peek()] >= arr[i]){
                st2.pop();
            }
            nse[i]=st2.isEmpty()?n:st2.peek();
            st2.push(i);
        }
        
        int res=0;
        for(int i=0;i<n;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            
            res+=(arr[i]*left*right);
        }
        
        return res;
        
    }
}
