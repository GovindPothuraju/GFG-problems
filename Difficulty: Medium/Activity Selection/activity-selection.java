class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int n=start.length;
        ArrayList<int[]> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new int[]{start[i],finish[i]});
        }
        
        Collections.sort(arr, (a,b)-> (a[1]-b[1]));
        
        int k=Integer.MIN_VALUE;
        int count=0;
        
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)[0] > k){
                k=arr.get(i)[1];
            }else{
                count++;
            }
        }
        return n-count;
    }
}
