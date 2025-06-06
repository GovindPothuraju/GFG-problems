class Solution {
    int maxLen(int arr[]) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=arr.length;
        int max=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0){
                max=Math.max(max,i+1);
            }
            else{
                if(hm.containsKey(sum)){
                    max=Math.max(max,i-hm.get(sum));
                }else{
                    hm.put(sum,i);
                }
            }
        }
        return max;
    }
}