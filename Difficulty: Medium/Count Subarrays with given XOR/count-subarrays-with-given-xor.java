class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int xor=0;
        long count=0;
        int n=arr.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        for(int i=0;i<n;i++){
            xor^=arr[i];
            int rem=k^xor;
            if(hm.containsKey(rem)){
                count+=hm.get(rem);
            }
            hm.put(xor,hm.getOrDefault(xor,0)+1);
        }
        return count;
    }
}