class Solution {
    public static int minCost(int[] arr) {
        // code here
        if(arr.length == 1) return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int res=0;
        while(!pq.isEmpty()){
            int v1=0,v2=0;
            if(!pq.isEmpty())v1=pq.poll();
            if(!pq.isEmpty())v2=pq.poll();
            int temp=v1+v2;
            res+=temp;
            if(!pq.isEmpty())pq.add(temp);
        }
        return res;
    }
}