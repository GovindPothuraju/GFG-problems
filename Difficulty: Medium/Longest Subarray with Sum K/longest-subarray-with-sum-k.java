// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=arr.length;
        int ans=0;
        int sum=0;
        //hm.put(0,1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==k){
                ans=Math.max(ans,i+1);
            }
            int rem=sum-k;
            if(hm.containsKey(rem)){
                ans=Math.max(ans,i-hm.get(rem));
            }
            if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }
            
        }
        return ans;
    }
}
