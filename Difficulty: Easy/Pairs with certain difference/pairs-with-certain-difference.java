class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            Collections.reverseOrder()
        );
        for(int num:arr){
            pq.add(num);
        }
        int res=0;
        while(pq.size()>1){
            int x=pq.poll();
            int y=pq.poll();
            
            int temp=x-y;
            if(temp < k){
                res+=(x+y);
            }else{
                pq.add(y);
            }
        }
        return res;
    }
}