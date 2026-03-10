class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        int res=0;
        for(int i=0;i<n;i++){
            res+=nse[i]-i;
        }
        return res;
    }
}
