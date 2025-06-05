
class Solution {
    static boolean pairInSortedRotated(int arr[], int target) {
        // Your code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]>target){
                continue;
            }
            int rem=target-arr[i];
            if(hm.containsKey(rem)){
                return true;
            }
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        return false;
    }
}
