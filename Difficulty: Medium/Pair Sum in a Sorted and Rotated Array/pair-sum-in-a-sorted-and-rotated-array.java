
class Solution {
    static boolean pairInSortedRotated(int arr[], int target) {
        // Your code here
        /*HashMap<Integer,Integer> hm=new HashMap<>();
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
        return false;*/
        /*Arrays.sort(arr);
        int n=arr.length;
        int l=0;
        int r=n-1;
        while(l<r){
            if(arr[l]+arr[r]==target){
                return true;
            }
            if(arr[l]+arr[r]>target){
                r--;
            }else{
                l++;
            }
        }
        return false;*/
        // without sorting
        int n=arr.length;
        int bp=0;
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i]){
                bp=i;
                break;
            }
        }
        int l=bp;
        int r=(n+bp-1)%n;
        while(l!=r){
            if(arr[l]+arr[r]==target){
                return true;
            }
            else if(arr[l]+arr[r]>target){
                r=(n+r-1)%n;
            }else{
                l=(l+1)%n;
            }
        }
        return false;
   
        
    }
}
