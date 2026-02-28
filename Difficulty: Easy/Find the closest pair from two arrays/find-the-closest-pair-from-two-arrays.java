class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        // Time complexity error o(n^2);
        // ArrayList<Integer> ans=new ArrayList<>();
        // int min=Integer.MAX_VALUE;
        // for(int i=0;i<arr1.length;i++){
        //     for(int j=0;j<arr2.length;j++){
        //         int sum=arr1[i]+arr2[j];
        //         int rem=Math.abs(sum-x);
        //         if(rem < min){
        //             min=rem;
        //             ans=new ArrayList<>(Arrays.asList(arr1[i], arr2[j]));
        //         }
        //     }
        // }
        // return ans;
        
        // trying optimized approach
        ArrayList<Integer> ans=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        
        int n=arr1.length;
        int m=arr2.length;
        int i=0;
        int j=m-1;
        
        while(i<n && j>=0){
            int sum=arr1[i]+arr2[j];
            int rem=Math.abs(sum-x);
            
            if(rem < min){
               min=rem;
               ans=new ArrayList<>(Arrays.asList(arr1[i], arr2[j]));
            }
            
            if(sum<x){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
}